package user;

/**
 * Class representing an user.
 * @author andreluiz
 *
 */
public class User {
	
	/**
	 * Password object of the User instance.
	 */
	private Password password;
	
	/**
	 * Email object of the User instance.
	 */
	private Email email;
	
	/**
	 * Birthday object of the User instance.
	 */
	private Birthday birthday;
	
	/**
	 * Constructor of an User instance.
	 * @param email Email of the user. This will be used as a login.
	 * @param password Password of the user. This will be encrypted.
	 * @param day Day of birth of the user.
	 * @param month Month of birth of the user.
	 * @param year Yearh of birth of the user.
	 */
	public User(String email, String password,
			int day, int month, int year) {
		this.setPassword(new Password(password));
		this.setEmail(new Email(email));
		this.setBirthday(new Birthday(day, month, year));

	}
	
	/**
	 * 
	 * @return Password object of the User instance.
	 */
	public Password getPassword() {
		return password;
	}
	
	/**
	 * 
	 * @param password Password object to set the on User instance. 
	 */
	public void setPassword(Password password) {
		this.password = password;
	}
	
	/**
	 * 
	 * @return Email object of the User instance.
	 */
	public Email getEmail() {
		return email;
	}
	
	/**
	 * 
	 * @param email Email object to set the on User instance.
	 */
	public void setEmail(Email email) {
		this.email = email;
	}
	
	/**
	 * 
	 * @return Birthday of the User instance.
	 */
	public Birthday getBirthday() {
		return birthday;
	}
	
	/**
	 * 
	 * @param birthday Birthday object to set the on User instance.
	 */
	public void setBirthday(Birthday birthday) {
		this.birthday = birthday;
	}
	
	@Override
	public String toString() {
		return "User [password=" + password + ", email=" + email
				+ ", birthday=" + birthday + "]";
	}
	

}
