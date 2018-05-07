package logia.assistant.share.common.app;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import logia.assistant.share.common.utils.UuidBuilder;

/**
 * The Class TestUuidUtils.
 *
 * @author Dai Mai
 */
public class TestUuidUtils {

    /** The count down. */
    private volatile AtomicInteger countDown;

    /** The size. */
    private int                    size;

    /** The UUI ds. */
    private List<String>           UUIDs;

    /**
     * Sets the up.
     *
     * @throws Exception the exception
     */
    public void setUp() throws Exception {
        this.size = 500000;
        this.countDown = new AtomicInteger(size);
        this.UUIDs = new ArrayList<>();
    }

    /**
     * Test.
     *
     * @throws Exception the exception
     */
    public void testGenerateUUIDConcurrent() throws Exception {
        int numThreads = 2;
        for (byte c = 0; c < numThreads; c++) {
            // Run with 4 threads
            new Thread(() -> {
                while (this.countDown.get() > 0) {
                    int i = this.countDown.getAndDecrement();
                    this.UUIDs.add(
                            new UuidBuilder().appendMaterial("clazz").appendMaterial(i).build());
                }
            }).start();
        }
        while (this.countDown.get() > 0) {
            long progress = (long) (((double) this.UUIDs.size() / (this.size * numThreads)) * 100);
            System.out.print(progress + "% " + "\r");
            Thread.sleep(100);
        }
        Set<String> testUUIDs = new HashSet<>(this.UUIDs);
        if (testUUIDs.size() == this.UUIDs.size()) {
            System.out.print("Success");
        }
        else {
            System.err.print("Fail");
        }
    }

    public static void main(String[] args) throws Exception {
        TestUuidUtils test = new TestUuidUtils();
        test.setUp();
        test.testGenerateUUIDConcurrent();
    }
}
