package net.alepuzio.authsys.domain.user.elementary.cripto.desede;

import java.security.spec.KeySpec;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;

import net.alepuzio.authsys.domain.user.elementary.cripto.Understandable;

public class Desede implements Understandable {

	private KeySpec ks;
	private SecretKeyFactory skf;
	private Cipher cipher;
	byte[] arrayBytes;
	private String myEncryptionKey;
	private String myEncryptionScheme;
	private SecretKey key;

	private Logger logger = Logger.getLogger(this.getClass());

	private Understandable origin;

	public Desede(Understandable understandable) throws Exception {
		this.origin = understandable;
		myEncryptionKey = EnumDesede.PWD.value();
		myEncryptionScheme = EnumDesede.DESEDE_ENCRYPTION_SCHEME.value();
		arrayBytes = myEncryptionKey.getBytes(EnumDesede.UNICODE_FORMAT.value());
		ks = new DESedeKeySpec(arrayBytes);
		skf = SecretKeyFactory.getInstance(myEncryptionScheme);
		cipher = Cipher.getInstance(myEncryptionScheme);
		key = skf.generateSecret(ks);
	}

	@Override
	public String decrypt() {
		String decryptedText = null;
		try {
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] plainText = new String(cipher.doFinal(Base64.decodeBase64(
					this.origin.decrypt())), EnumDesede.UNICODE_FORMAT.value())
					.getBytes();
			decryptedText = new String(plainText);
		} catch (Exception e) {
			// new MyException(e, logger).error().exception(); TODO throwable
			logger.error(e);
			throw new RuntimeException(e.getMessage());
		}
		return decryptedText;
	}

	@Override
	public String encrypt() {
		String encryptedString = null;
		try {
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] plainText = this.origin.encrypt().getBytes(EnumDesede.UNICODE_FORMAT.value());
			byte[] encryptedText = cipher.doFinal(plainText);
			encryptedString = new String(Base64.encodeBase64(encryptedText));
		} catch (Exception e) {
			// new MyException(e, logger).error().exception(); TODO throwable
			logger.error(e);
			throw new RuntimeException(e.getMessage());
		}
		return encryptedString;
	}

}
