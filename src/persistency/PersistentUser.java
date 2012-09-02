package persistency;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import user.User;

/**
 * Class that makes User serializable.
 * @author andreluiz
 *
 */
public class PersistentUser extends User implements Serializable {

	/**
	 * Serializable class version number.
	 * Value: 1
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Complete constructor of PersistentUser. This will create a User and persist it.
	 * @param email Email to be used.
	 * @param password Password to be used.
	 * @param day Day of birth.
	 * @param month Month of birth.
	 * @param year Year of birth.
	 */
	public PersistentUser(String email, String password, int day, int month,
			int year) {
		super(email, password, day, month, year);
	}

	/**
	 * Constructor of PersistentUser using a User instance.
	 * @param newUser User to Persisted.
	 */
	public PersistentUser(User newUser) {
		super(newUser);
	}


}