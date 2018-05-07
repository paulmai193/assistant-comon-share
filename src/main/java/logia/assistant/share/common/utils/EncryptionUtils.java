package logia.assistant.share.common.utils;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

/**
 * The Class EncryptionUtils.
 *
 * @author Dai Mai
 */
public final class EncryptionUtils {

    /** The Constant ITERATION_COUNT. */
    private final static int    ITERATION_COUNT = 31;

    /** The Random Constant SALT. */
    private static final byte[] SALT            = { (byte) 0x6C, (byte) 0x6F, (byte) 0x67,
            (byte) 0x69, (byte) 0x61, (byte) 0x31, (byte) 0x39, (byte) 0x33 };
    /**
     * Decode.
     *
     * @param token the token
     * @param password the password
     * @return the string
     * @throws InvalidKeySpecException the invalid key spec exception
     * @throws NoSuchAlgorithmException the no such algorithm exception
     * @throws NoSuchPaddingException the no such padding exception
     * @throws InvalidKeyException the invalid key exception
     * @throws InvalidAlgorithmParameterException the invalid algorithm parameter exception
     * @throws IllegalBlockSizeException the illegal block size exception
     * @throws BadPaddingException the bad padding exception
     */
    public static String decode(String token, String password) throws InvalidKeySpecException,
            NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
            InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        if (token == null) {
            return null;
        }
        String input = token.replace("%0A", "\n").replace("%25", "%").replace('_', '/').replace('-',
                '+');

        byte[] dec = Base64.getDecoder().decode(input.getBytes());

        KeySpec keySpec = new PBEKeySpec(password.toCharArray(), EncryptionUtils.SALT,
                EncryptionUtils.ITERATION_COUNT);
        AlgorithmParameterSpec paramSpec = new PBEParameterSpec(EncryptionUtils.SALT,
                EncryptionUtils.ITERATION_COUNT);

        SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(keySpec);

        Cipher dcipher = Cipher.getInstance(key.getAlgorithm());
        dcipher.init(Cipher.DECRYPT_MODE, key, paramSpec);

        byte[] decoded = dcipher.doFinal(dec);

        String result = new String(decoded);
        return result;
    }

    /**
     * Encode.
     *
     * @param input the input
     * @param password the password
     * @return the string
     * @throws InvalidKeySpecException the invalid key spec exception
     * @throws NoSuchAlgorithmException the no such algorithm exception
     * @throws NoSuchPaddingException the no such padding exception
     * @throws InvalidKeyException the invalid key exception
     * @throws InvalidAlgorithmParameterException the invalid algorithm parameter exception
     * @throws IllegalBlockSizeException the illegal block size exception
     * @throws BadPaddingException the bad padding exception
     */
    public static String encode(String input, String password) throws InvalidKeySpecException,
            NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
            InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        if (input == null) {
            throw new IllegalArgumentException();
        }

        KeySpec keySpec = new PBEKeySpec(password.toCharArray(), EncryptionUtils.SALT,
                EncryptionUtils.ITERATION_COUNT);
        AlgorithmParameterSpec paramSpec = new PBEParameterSpec(EncryptionUtils.SALT,
                EncryptionUtils.ITERATION_COUNT);

        SecretKey key = SecretKeyFactory.getInstance("PBEWithMD5AndDES").generateSecret(keySpec);

        Cipher ecipher = Cipher.getInstance(key.getAlgorithm());
        ecipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);

        byte[] enc = ecipher.doFinal(input.getBytes());

        String res = new String(Base64.getEncoder().encode(enc));
        // escapes for url
        res = res.replace('+', '-').replace('/', '_').replace("%", "%25").replace("\n", "%0A");

        return res;

    }
}
