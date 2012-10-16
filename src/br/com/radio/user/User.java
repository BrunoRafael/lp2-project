package br.com.radio.user;

import br.com.radio.social.Profile;

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
	 * User's profile.
	 */
	private Profile profile;
	
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
		this.setProfile(new Profile());

	}
	
	/**
	 * Auxiliar constructor to clone an User.
	 * @param newUser User to be cloned.
	 */
	public User(User newUser) {
		this.setPassword(newUser.getPassword());
		this.setEmail(newUser.getEmail());
		this.setBirthday(newUser.getBirthday());
		this.setProfile(newUser.getProfile());
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
	
	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	@Override
	public String toString() {
		return "User [password=" + this.getPassword() + ", " + this.getEmail()
				+ ", " + this.getBirthday() + " " + this.getProfile() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((birthday == null) ? 0 : birthday.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (birthday == null) {
			if (other.birthday != null)
				return false;
		} else if (!birthday.equals(other.birthday))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
			else
				return true;
		}
		return true;
	}

}
