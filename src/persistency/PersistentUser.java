package persistency;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
	
	private FileOutputStream userFile;
	private ObjectOutputStream userDb;
	
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

	public void writeUser() throws IOException {
		this.getUserDb().writeObject(this);
	}
	
	public void writeUser(PersistentUser pu) throws IOException {
		
	}
	
	public void setUp() {
		File tmp = null;
		try{
			tmp = new File("../res/users.data");
			userFile = new FileOutputStream(tmp);
		} catch (FileNotFoundException e) {
			if(!tmp.exists())
				try {
					tmp.createNewFile();
					userFile = new FileOutputStream(tmp);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
		}
		
		try {
			setUserDb(new ObjectOutputStream(userFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ObjectOutputStream getUserDb() {
		return userDb;
	}

	public void setUserDb(ObjectOutputStream userDb) {
		this.userDb = userDb;
	}

	public FileOutputStream getUserFile() {
		return userFile;
	}

	public void setUserFile(FileOutputStream userFile) {
		this.userFile = userFile;
	}
}
