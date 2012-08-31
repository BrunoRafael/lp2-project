package persistency;

import java.io.Serializable;

import user.User;

public class PresistentUser extends User implements Serializable {

	/**
	 * Serializable class version number.
	 * Value: 1
	 */
	private static final long serialVersionUID = 1L;

	public PresistentUser(String email, String password, int day, int month,
			int year) {
		super(email, password, day, month, year);
	}

	public PresistentUser(User newUser) {
		super(newUser);
	}

}
