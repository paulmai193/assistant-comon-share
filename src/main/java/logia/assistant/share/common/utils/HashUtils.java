package logia.assistant.share.common.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * The Class HashUtils.
 *
 * @author Dai Mai
 */
public final class HashUtils {

    /**
     * Encode MD5.
     *
     * @param s the s
     * @return the string
     * @throws NoSuchAlgorithmException the no such algorithm exception
     */
    public static String encodeMD5(final String s) throws NoSuchAlgorithmException {
        // Create MD5 Hash
        MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
        digest.update(s.getBytes());
        byte messageDigest[] = digest.digest();

        // Create Hex String
        StringBuffer hexString = new StringBuffer();
        for (byte element : messageDigest) {
            String h = Integer.toHexString(0xFF & element);
            while (h.length() < 2) {
                h = "0" + h;
            }
            hexString.append(h);
        }
        return hexString.toString();
    }
    
    /**
     * Encode SHA 256.
     *
     * @param s the s
     * @return the string
     * @throws NoSuchAlgorithmException the no such algorithm exception
     */
    public static String encodeSHA256(final String s) throws NoSuchAlgorithmException {
        // Create SHA-256 Hash
        MessageDigest digest = java.security.MessageDigest.getInstance("SHA-256");
        return encodeSHA(digest, s);
    }
    
    /**
     * Encode SHA 512.
     *
     * @param s the s
     * @return the string
     * @throws NoSuchAlgorithmException the no such algorithm exception
     */
    public static String encodeSHA512(final String s) throws NoSuchAlgorithmException {
        // Create SHA-512 Hash
        MessageDigest digest = java.security.MessageDigest.getInstance("SHA-512");
        return encodeSHA(digest, s);
    }
    
    /**
     * Encode SHA.
     *
     * @param digest the digest
     * @param s the s
     * @return the string
     * @throws NoSuchAlgorithmException the no such algorithm exception
     */
    private static String encodeSHA(MessageDigest digest, final String s) throws NoSuchAlgorithmException {
        digest.update(s.getBytes());
        byte messageDigest[] = digest.digest();

        // Create Hex String
        StringBuffer hexString = new StringBuffer();
        for (byte element : messageDigest) {
            String h = Integer.toHexString(0xFF & element);
            while (h.length() < 2) {
                h = "0" + h;
            }
            hexString.append(h);
        }
        return hexString.toString();
    }

}
