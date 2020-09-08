import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Base64;

/**
 * AES工具
 * Created by cznno on 17-8-16.
 */
public class AESUtil {

    private Cipher cipher;
    private Charset charSet;

    public AESUtil() {
    }

    public AESUtil(Cipher cipher) {
        this.cipher = cipher;
    }

    public AESUtil(String cipher, String provider) throws NoSuchPaddingException, NoSuchAlgorithmException, NoSuchProviderException {
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        this.cipher = Cipher.getInstance(cipher, provider);
        this.charSet = StandardCharsets.UTF_8;
    }

    public Cipher getCipher() {
        return cipher;
    }

    public void setCipher(Cipher cipher) {
        this.cipher = cipher;
    }

    public Charset getCharSet() {
        return charSet;
    }

    public void setCharSet(Charset charSet) {
        this.charSet = charSet;
    }

    /**
     * @param inputText     密文
     * @param encryptionKey 密钥
     * @param iv            偏移量
     * @return 解密文本
     */
    @Deprecated
    public byte[] decrypt(String inputText, String encryptionKey, String iv) throws UnsupportedEncodingException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        final String charSetName = this.charSet.name();
        return decrypt(inputText.getBytes(charSetName), encryptionKey.getBytes(charSetName), iv.getBytes(charSetName));
    }

    public byte[] decrypt(byte[] input, byte[] key, byte[] iv) throws InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        this.cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(key, "AES"), new IvParameterSpec(iv));
        return this.cipher.doFinal(input);
    }

    /**
     * @param inputText 待加密文本
     * @param key       密钥
     * @param iv        偏移量
     * @return 密文
     */
    public byte[] encrypt(String inputText, String key, String iv)
            throws UnsupportedEncodingException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        final String charSetName = this.charSet.name();
        return encrypt(inputText.getBytes(charSetName), key.getBytes(charSetName), iv.getBytes(charSetName));
    }

    public byte[] encrypt(byte[] input, byte[] key, byte[] iv) throws InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        this.cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key, "AES"), new IvParameterSpec(iv));
        return this.cipher.doFinal(input);
    }

    private byte[] hexStringToBytes(String s) {
        if (s.length() % 2 > 0) {
            s = "0" + s;
        }
        byte[] bytes = new byte[s.length() / 2];
        for (int i = 0; i < (s.length() / 2); i++) {
            bytes[i] = Byte.valueOf(s.substring(i, i + 2));
        }
        return bytes;
    }
}
