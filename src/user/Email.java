package user;

/**
 * Class representing an email such as 'abcd@zzz.com'.
 * 
 * @author andreluiz
 * @see http://en.wikipedia.org/wiki/Email_address
 */
public class Email {
	
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
		this.local = local;
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
		this.domain = domain;
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
