package user;

import static org.junit.Assert.*;
import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;


public class EmailTest extends TestCase {
	
	private String bigLocal;
	private String bigDomain;
	
	private Email firstEmail, secondEmail, thirdEmail;
	

	public EmailTest() {
		bigLocal = new String("a");
		for(int i = 0; i < 70; i++) 
			bigLocal = bigLocal.concat("a");
					
		bigDomain = new String("c");
		for(int i = 0; i < 257; i++)
			bigDomain = bigDomain.concat("c");
		bigDomain = bigDomain.concat(".com");
	}

	@Test
	public void testEmail() {
		this.firstEmail = new Email("abcd", "fulano.com");
		this.secondEmail = new Email(bigLocal, "fulano.com");
		this.thirdEmail = new Email("abcd", bigDomain);
	}

	@Test
	public void testGetlocal() {
		this.firstEmail = new Email("abcd", "fulano.com");
		assertEquals(this.firstEmail.getlocal(), "abcd");
		this.secondEmail = new Email(bigLocal, "fulano.com");
		assertEquals(this.secondEmail.getlocal(), null);
	}

	@Test
	public void testSetlocal() {
		this.firstEmail = new Email("a.little.lengthy.but.fine", "dept.example.com");
		this.firstEmail.setlocal("abc..3");
	}

	@Test
	public void testGetDomain() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetDomain() {
		fail("Not yet implemented");
	}

	@Test
	public void testEqualsObject() {
		fail("Not yet implemented");
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

}
