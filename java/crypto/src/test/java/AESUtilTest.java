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
    private byte[] encryptedHex = {};
    private String key = "dgafa33sdfar21gh";
    private String iv = "fawrasdfa33swr12";

    AESUtilTest() throws NoSuchPaddingException, NoSuchAlgorithmException, NoSuchProviderException {}

    @Test
    void foo() {
        String s = "b060bb29bff4e62d09fbd7d123836c700d2b4a1c575c11ddf763d5e3a514cabce63421247b3269a933fee78f7628d067";

//        for (int i = 0; i < s.length(); i += 2) {
//            System.out.print(s.substring(i, i + 2) + " ");
//        }
//        System.out.println();
//        final byte[] decode = Base64.getDecoder().decode("sGC7Kb/05i0J+9fRI4NscA0rShxXXBHd92PV46UUyrzmNCEkezJpqTP+5492KNBn");
//        System.out.println(javax.xml.bind.DatatypeConverter.printHexBinary(decode));
    }

    @Test
    void singleDecrypt() throws IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, InvalidKeyException, UnsupportedEncodingException {
        final byte[] output = aesUtil.decrypt(encrypted, key, iv);
        assertEquals(origin, new String(output, aesUtil.getCharSet()));
    }

    @Test
    void singleEncrypt() throws IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, InvalidKeyException, UnsupportedEncodingException {
        final byte[] output = Base64.getEncoder().encode(aesUtil.encrypt(origin, key, iv));
        assertEquals(encrypted, new String(output));
    }

    @Test
    void encryptThenDecrypt() throws IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, InvalidKeyException, UnsupportedEncodingException {
        final String input = "Seeing is believing";
        final byte[] encrypt = aesUtil.encrypt(input, key, iv);
        final byte[] decrypt = aesUtil.decrypt(new String(encrypt, aesUtil.getCharSet()), key, iv);
        assertEquals(input, new String(decrypt, aesUtil.getCharSet()));
    }
}