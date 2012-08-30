package user;

public class User {
	
	private Password password;
	private Email email;
	private Birthday birthday;
	
	public User(String email, String password,
			int day, int month, int year) {
		this.setPassword(new Password(password));
		this.setEmail(new Email(email));
		this.setBirthday(new Birthday(day, month, year));

	}
	public Password getPassword() {
		return password;
	}
	
	public void setPassword(Password password) {
		this.password = password;
	}
	
	public Email getEmail() {
		return email;
	}
	
	public void setEmail(Email email) {
		this.email = email;
	}
	
	public Birthday getBirthday() {
		return birthday;
	}
	
	public void setBirthday(Birthday birthday) {
		this.birthday = birthday;
	}
	
	@Override
	public String toString() {
		return "User [password=" + password + ", email=" + email
				+ ", birthday=" + birthday + "]";
	}
	

}
