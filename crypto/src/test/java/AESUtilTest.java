import org.junit.jupiter.api.Test;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Base64;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by cznno
 * Date: 18-6-12
 */
class AESUtilTest {

    private AESUtil aesUtil = new AESUtil("AES/CBC/PKCS5Padding", "SunJCE");
    private String origin = "其实我并不理解他在说什么";
    private String encrypted = "sGC7Kb/05i0J+9fRI4NscA0rShxXXBHd92PV46UUyrzmNCEkezJpqTP+5492KNBn";
    private String key = "dgafa33sdfar21gh";
    private String iv = "fawrasdfa33swr12";

    AESUtilTest() throws NoSuchPaddingException, NoSuchAlgorithmException, NoSuchProviderException {}

    @Test
    void decrypt() throws IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, InvalidKeyException, UnsupportedEncodingException {
        final String output = aesUtil.decrypt(Base64.getDecoder().decode(encrypted), key, iv);
        assertEquals(origin, output);
    }

    @Test
    void encrypt() throws IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, InvalidKeyException, UnsupportedEncodingException {
        final byte[] output = Base64.getEncoder().encode(aesUtil.encrypt(origin, key, iv));
        assertEquals(encrypted, new String(output));
    }
}