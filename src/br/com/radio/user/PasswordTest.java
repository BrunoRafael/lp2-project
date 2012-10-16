package br.com.radio.user;

import static org.junit.Assert.*;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.NoSuchPaddingException;

import junit.framework.TestCase;

import org.junit.Test;

public class PasswordTest extends TestCase {

	private String firstPass = "root00";
	
	@Test
	public void testPassword() {
		Password p = new Password(firstPass);
		Password p1 = new Password("root11");
		assertTrue(Password.comparePasswords(p, firstPass));
		assertFalse(Password.comparePasswords(p1, firstPass));
		assertTrue(Password.comparePasswords(p1, "root11"));
	}

	@Test
	public void testGetKey() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetKey() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetEncryptedPass() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetEncryptedPass() {
		fail("Not yet implemented");
	}

}
