package logia.assistant.share.common.utils;

import java.security.SecureRandom;
import java.util.UUID;

import org.springframework.util.Base64Utils;

/**
 * The Class UuidUtils.
 *
 * @author Dai Mai
 */
public final class UuidUtils {
    
    /** The Constant THREAD_LOCAL_SECURE_RANDOM. */
    private static final ThreadLocal<SecureRandom> THREAD_LOCAL_SECURE_RANDOM = new ThreadLocal<SecureRandom>();
    
    /**
     * Generate uui.
     *
     * @return the string
     */
    public static String newSecureUUIDString() {
        return Base64Utils.encodeToUrlSafeString(newSecureUUID().toString().getBytes());
    }
    
    /**
     * New secure UUID.
     *
     * @return the uuid
     */
    public static UUID newSecureUUID() {
        byte[] data = new byte[16];
        getSecure().nextBytes(data);

        // clear version
        data[6] &= 0x0f;
        // set to version 4
        data[6] |= 0x40;
        // clear variant
        data[8] &= 0x3f;
        // set to IETF variant
        data[8] |= 0x80;

        long mostSigBits = 0;
        long leastSigBits = 0;
        assert data.length == 16 : "data must be 16 bytes in length";
        for (int i = 0; i < 8; i++) {
            mostSigBits = (mostSigBits << 8) | (data[i] & 0xff);
        }
        for (int i = 8; i < 16; i++) {
            leastSigBits = (leastSigBits << 8) | (data[i] & 0xff);
        }
        return new UUID(mostSigBits, leastSigBits);
    }
    
    /**
     * Gets the secure.
     *
     * @return the secure
     */
    private static SecureRandom getSecure() {
        SecureRandom random = THREAD_LOCAL_SECURE_RANDOM.get();
        if (random == null) {
            random = new SecureRandom();
            THREAD_LOCAL_SECURE_RANDOM.set(random);
        }
        return random;
    }
}
