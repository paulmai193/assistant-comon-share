package logia.assistant.share.common.utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.util.Base64Utils;

/**
 * The Class UuidUtils.
 *
 * @author Dai Mai
 */
public final class UuidUtils {
    
    /**
     * Generate uui.
     *
     * @param id the id
     * @return the string
     */
    public static String generateUui(Long id) {
        int length = 19 - id.toString().length();
        String randomString = id.toString() + RandomStringUtils.randomNumeric(length);
        return Base64Utils.encodeToUrlSafeString(randomString.getBytes());
    }
}
