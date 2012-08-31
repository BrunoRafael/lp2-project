package manager;

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
	
	/**
	 * Protected constructor to prevent outside instantiation.
	 */
	protected UserManager() {
	
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
		

}
