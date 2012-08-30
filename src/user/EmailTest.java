package user;

import junit.framework.TestCase;

import org.junit.Test;


public class EmailTest extends TestCase {
	
	private String bigLocal;
	private String bigDomain;
	
	private Email firstEmail, secondEmail;
	

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
		new Email("abcd", bigDomain);
	}

	@Test
	public void testgetLocal() {
		this.firstEmail = new Email("abcd", "fulano.com");
		assertEquals(this.firstEmail.getLocal(), "abcd");
		this.secondEmail = new Email(bigLocal, "fulano.com");
		assertEquals(this.secondEmail.getLocal(), null);
	}

	@Test
	public void testsetLocal() {
		this.firstEmail = new Email("a.little.lengthy.but.fine", "dept.example.com");
		this.firstEmail.setLocal("abc..3");
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
