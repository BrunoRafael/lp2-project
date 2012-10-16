package br.com.radio.manager;

import java.util.List;

import br.com.radio.persistence.PersistenceHandler;
import br.com.radio.user.User;


/**
 * Singleton UserManager class.
 * This class will handle CRUD operations.
 * @author andreluiz
 *
 */
public class UserManager {

	/**
	 * Singleton instance of UserManager.
	 */
	private static UserManager instance = null;
	PersistenceHandler persistencyUser;
	/**
	 * Protected constructor to prevent outside instantiation.
	 */
	protected UserManager() {
		persistencyUser = new PersistenceHandler();
	}
	
	/**
	 * Method to get the UserManager instance.
	 * @return UserManager instance.
	 */
	public static UserManager getInstance() {
		if(instance == null)
			instance = new UserManager();
		return instance;
	}
	
	public List<User> getUsersRegistered(){
		persistencyUser.getUserDbIn();
		return null;
	}
	public void persistUser(User user){
		
	}
		

}
