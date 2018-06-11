import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.*;

/**
 * AES工具
 * Created by cznno on 17-8-16.
 */
public class AESUtil {

    private Cipher cipher;

    public AESUtil(String cipher, String provider) throws NoSuchPaddingException, NoSuchAlgorithmException, NoSuchProviderException {
        Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
        this.cipher = Cipher.getInstance(cipher, provider);
    }

    /**
     * @param cipherText    密文
     * @param encryptionKey 密钥
     * @param IV            偏移量
     * @return 解密文本
     */
    public String decrypt(byte[] cipherText, String encryptionKey, String IV) throws UnsupportedEncodingException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        SecretKeySpec key = new SecretKeySpec(encryptionKey.getBytes("UTF-8"), "AES");
        this.cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(IV.getBytes("UTF-8")));
        return new String(this.cipher.doFinal(cipherText), "UTF-8");
    }

    /**
     * @param plainText     待加密文本
     * @param encryptionKey 密钥
     * @param IV            偏移量
     * @return 密文
     */
    public byte[] encrypt(String plainText, String encryptionKey, String IV)
            throws UnsupportedEncodingException, InvalidAlgorithmParameterException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        SecretKeySpec key = new SecretKeySpec(encryptionKey.getBytes("UTF-8"), "AES");
        this.cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(IV.getBytes("UTF-8")));
        return this.cipher.doFinal(plainText.getBytes("UTF-8"));
    }
}
