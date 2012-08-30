package user;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Class representing an email such as 'abcd@zzz.com'.
 * 
 * @author andreluiz
 * @see http://en.wikipedia.org/wiki/Email_address
 */
public class Email {
	
	/**
	 * Regex pattern for local part validation.
	 */
	private static final String LOCAL_REGEX = 
             "^[a-z0-9,!#\\" + 
             "$%&'\\" + "*\\" +"+/=\\" + "?\\ " + "^_`\\" + "{\\" + 
             "|}~-]+(\\" + ".[a-z0-9,!#\\" + "$%&'\\ " + 
             "*\\" + " +/=\\" + "?\\" + "^_`\\" + "{\\" + "|}~-]+)*";
	
	/**
	 * Regex pattern for the domain part validation.
	 */
	private static final String DOMAIN_REGEX =
             "[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	/**
	 * Pattern object to hold local part pattern.
	 */
	private Pattern localPattern = Pattern.compile(LOCAL_REGEX);
	
	/**
	 * Pattern object to hold domain part pattern.
	 */
	private Pattern domainPattern = Pattern.compile(DOMAIN_REGEX);
	
	/**
	 * Matcher object to match patterns with locals and domains.
	 */
	private Matcher matcher;
	
	/**
	 * Local part.
	 */
	private String local;
	
	/**
	 * Domain part.
	 */
	private String domain;
	
	/**
	 * Default constructor of an Email object.
	 * @param local Local part.
	 * @param domain Domain part.
	 */
	public Email(String local, String domain) {
		this.setDomain(domain);
		this.setlocal(local);
	}
	
	/**
	 * 
	 * @return The object local's part.
	 */
	public String getlocal() {
		return local;
	}
	
	/**
	 * @see http://en.wikipedia.org/wiki/Email_address#Local_part
	 * @param local See the wikipedia given link to check for valid local parts.
	 */
	public void setlocal(String local) {
		if(local.length() < 65) {
			try {
				isValidLocal(local);
				this.local = local;
			} catch(Exception e) {
				System.out.println(e.getMessage());
				System.out.println("Local not set.");
			}
		}
		else
			System.out.println("Local part length must be less than 65 characters");
	}
	
	/**
	 * 
	 * @return The object domain's part.
	 */
	public String getDomain() {
		return domain;
	}
	
	/**
	 * @see http://en.wikipedia.org/wiki/Email_address#Domain_part
	 * @param domain Check the wikipedia given link to check for valid domain parts. 
	 */
	public void setDomain(String domain) {
		if(domain.length() < 256) {
		try {
			isValidDomain(domain);
			this.domain = domain;
		} catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Domain not set.");
		}
		}
		else
			System.out.println("Domain part length must be less than 256 characters");
	}
	

	/**
	 * Method to check if a given local part is valid.
	 * @param local Local part to be tested.
	 * @return true if its valid, false otherwise.
	 */
	private boolean isValidLocal(String local) throws Exception {
		this.matcher = localPattern.matcher(local);
		if(!this.matcher.matches())
			throw new Exception("Invalid local part.");
			
		return true;
	}

	/**
	 * Method to check if a given domain part is valid.
	 * @param domain domain part to be tested.
	 * @return true if its valid, false otherwise.
	 */
	private boolean isValidDomain(String domain) throws Exception {
		this.matcher = domainPattern.matcher(domain);
		if(!this.matcher.matches())
			throw new Exception("Invalid domain part.");
		
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((domain == null) ? 0 : domain.hashCode());
		result = prime * result + ((local == null) ? 0 : local.hashCode());
		return result;
	}
	
	/**
	 * An email equals other email if all of their fields match.
	 * @param obj 
	 * @return Boolean matching the equality of emails.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Email other = (Email) obj;
		if (domain == null) {
			if (other.domain != null)
				return false;
		} else if (!domain.equals(other.domain))
			return false;
		if (local == null) {
			if (other.local != null)
				return false;
		} else if (!local.equals(other.local))
			return false;
		return true;
	}
	
	/**
	 * String representation of an Email object.
	 * @return String containing Email objects attributes.
	 */
	@Override
	public String toString() {
		return "Email [local=" + this.getlocal() + 
			   ", domain=" + this.getDomain() + "]";
	}


}
