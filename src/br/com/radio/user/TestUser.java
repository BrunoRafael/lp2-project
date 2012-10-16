package br.com.radio.user;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Test;

public class TestUser extends TestCase {

	private User u;
	private User u1;
	
	@Test
	public void testUser() {
		u = new User("fulano@ccc.com", "root00", 24, 8, 1989);
		u1 = new User("cicrano@ddd.com", "root11", 30, 8, 1989);
		
		assertEquals("fulano", u.getEmail().getLocal());
		assertEquals("ccc.com", u.getEmail().getDomain());
		assertFalse(u.equals(u1));
		User u2 = new User(u);
		assertEquals(u, u2);
		
	}

	@Test
	public void testGetPassword() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetPassword() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetEmail() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetEmail() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetBirthday() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetBirthday() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

}
