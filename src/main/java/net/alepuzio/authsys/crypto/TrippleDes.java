package net.alepuzio.authsys.crypto;

import java.security.spec.KeySpec;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

import net.alepuzio.authsys.crypto.exception.MyException;
/***
 * @overview: this class encrypts and decrypts String.
 * I tried to refactor in more class but Cipher showed an incoherent behaviour as compared to unit test, then I preferred to pospone this work.
 * The class is copied from https://stackoverflow.com/questions/10303767/encrypt-and-decrypt-in-java/10316509#10316509
 * read https://stackoverflow.com/questions/34110062/java-decryption-input-length-must-be-multiple-of-8-when-decrypting-with-padded
 * */
public class TrippleDes {

    private static final String UNICODE_FORMAT = "UTF8";
    public static final String DESEDE_ENCRYPTION_SCHEME = "DESede";
    private KeySpec ks;
    private SecretKeyFactory skf;
    private Cipher cipher;
    byte[] arrayBytes;
    private String myEncryptionKey;
    private String myEncryptionScheme;
    private SecretKey key;
    
    private Logger logger = Logger.getLogger(this.getClass());
    
    public TrippleDes() throws Exception {
        myEncryptionKey = "ThisIsSpartaThisIsSparta";
        myEncryptionScheme = DESEDE_ENCRYPTION_SCHEME;
        arrayBytes = myEncryptionKey.getBytes(UNICODE_FORMAT);
        ks = new DESedeKeySpec(arrayBytes);
        skf = SecretKeyFactory.getInstance(myEncryptionScheme);
        cipher = Cipher.getInstance(myEncryptionScheme);
        key = skf.generateSecret(ks);
    }

    /**
     * @return the encrypted string
     * @param unencryptedString: string to encrypt 
     * */
    public String encrypt(String unencryptedString) throws Exception {
        String encryptedString = null;
        try {
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] plainText = unencryptedString.getBytes(UNICODE_FORMAT);
            byte[] encryptedText = cipher.doFinal(plainText);
            encryptedString = new String(Base64.encodeBase64(encryptedText));
        } catch (Exception e) {
            new MyException(e, logger).error().exception();
        }
        return encryptedString;
    }

    /**
     * @return the decrypted string
     * @param encryptedString: string to decrypt 
     * */
    public String decrypt(String encryptedString) throws Exception {
        String decryptedText=null;
        try {
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] plainText = new String( cipher.doFinal(Base64.decodeBase64(encryptedString)), UNICODE_FORMAT).getBytes();
            decryptedText= new String(plainText);
        } catch (Exception e) {
        	new MyException(e, logger).error().exception();
        }
        return decryptedText;
    }


}