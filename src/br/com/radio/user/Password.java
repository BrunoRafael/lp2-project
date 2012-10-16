package br.com.radio.user;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

/**
 * Class representing a password. It keeps a key and an encrypted password.
 * @author andreluiz
 *
 */
public class Password {
	
	/**
	 * Key to be used on encryption and decryption.
	 */
	private SecretKey key;
	
	/**
	 * Cipher object responsible of encryption.
	 */
	private Cipher encrypter;
	
	/**
	 * Cipher object responsible of decryption.
	 */
	private Cipher decrypter;
	
	/**
	 * Encypted password encoded to Base64.
	 */
	private String encryptedPass;
	
	/**
	 * Default constructor of Password class.
	 * @param pass Password to be encrypted.
	 * @throws NoSuchAlgorithmException
	 * @throws InvalidKeyException
	 * @throws NoSuchPaddingException
	 */
	public Password(String pass) {
		try {
			this.setKey();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		try {
			this.setupCipher();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		}
		this.encrypt(pass);
	}
	
	/**
	 * Method responsible of setting up Cipher for both encryption and decryption using DES algorithm.
	 * @throws NoSuchAlgorithmException
	 * @throws NoSuchPaddingException
	 * @throws InvalidKeyException
	 */
	private void setupCipher() throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException {
		encrypter = Cipher.getInstance("DES");
		decrypter = Cipher.getInstance("DES");
		this.setKey();
		encrypter.init(Cipher.ENCRYPT_MODE, this.getKey());
		decrypter.init(Cipher.DECRYPT_MODE, this.getKey());
	}
	
	/**
	 * Private method to encrypt the Password pass attribute.
	 * @param pass Password to be encrypted.
	 */
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
	
	/**
	 * Private method to return the decrypted password attribute of Password.
	 * @return The decrypted password of the instance.
	 */
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
	
	/**
	 * 
	 * @return SecretKey object.
	 */
	public SecretKey getKey() {
		return key;
	}
	
	/**
	 * Sets the key attribute to get an instance using DES algorithm.
	 * The key is generated automatically.
	 * @throws NoSuchAlgorithmException
	 */
	public void setKey() throws NoSuchAlgorithmException {
		this.key = KeyGenerator.getInstance("DES").generateKey();
	}
	
	/**
	 * 
	 * @return Encrypted password encoded on Base64.
	 */
	public String getEncryptedPass() {
		return encryptedPass;
	}
	
	/**
	 * Sets the encryptedPass attribute to the given encrypted password.
	 * @param encryptedPassword Base64 string containing an encrypted password.
	 */
	private void setEncryptedPass(String encryptedPassword) {
		this.encryptedPass = encryptedPassword;
	}
	
	/**
	 * Method that compares a Password with an string.
	 * @param p1 Password object to test the match.
	 * @param password Password to test if matches the Password object decrypted password.
	 * @return true if the given password matches the Password object decrypted password.
	 */
	public static boolean comparePasswords(Password p1, String password) {
		return p1.decrypt().equals(password);
	}

	@Override
	public String toString() {
		return "[" + encryptedPass + "]";
	}
}
