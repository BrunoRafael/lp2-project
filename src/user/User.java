package user;

public class User {
	
	private Password password;
	private Email email;
	private Birthday birthday;
	
	
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
