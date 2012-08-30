package user;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

public class Password {
	
	private SecretKey key;
	private Cipher encrypter;
	private Cipher decrypter;
	private String encryptedPass;
	
	public Password(String pass) throws NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException {
		this.setKey();
		this.setupCipher();
		this.encrypt(pass);
	}
	
	private void setupCipher() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
		encrypter = Cipher.getInstance("DES");
		decrypter = Cipher.getInstance("DES");
		this.setKey();
		encrypter.init(Cipher.ENCRYPT_MODE, this.getKey());
		decrypter.init(Cipher.DECRYPT_MODE, this.getKey());
	}
	
	private void encrypt(String pass) {
		try {
			byte[] utf8 = pass.getBytes("UTF8");
			byte[] enc = this.encrypter.doFinal(utf8);
			this.setEncryptedPass(Base64.encode(enc));
		} catch (javax.crypto.BadPaddingException e) {
		} catch (IllegalBlockSizeException e) {
		} catch (UnsupportedEncodingException e) {
		}
	}
	
	private String decrypt() {
		try {
			byte[] dec = Base64.decode(this.getEncryptedPass());
			byte[] utf8 = this.decrypter.doFinal(dec);

			return new String(utf8, "UTF8");
		} catch (javax.crypto.BadPaddingException e) {
		} catch (IllegalBlockSizeException e) {
		} catch (UnsupportedEncodingException e) {
		}
		return new String();
	}
	
	public SecretKey getKey() {
		return key;
	}
	public void setKey() throws NoSuchAlgorithmException {
		this.key = KeyGenerator.getInstance("DES").generateKey();
	}
	public String getEncryptedPass() {
		return encryptedPass;
	}
	public void setEncryptedPass(String encryptedPassword) {
		this.encryptedPass = encryptedPassword;
	}
	
}
