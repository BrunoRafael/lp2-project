package br.com.radio.persistence;

import java.util.List;

public class PersistenceManager {
	private PersistenceHandler persistenceUser;
	
	public PersistenceManager(){
		persistenceUser = new PersistenceHandler();
	}
	
	public List<UserPersisted> getUsersRegistereds(){
		persistenceUser.getUserDbIn();
		return null;
	}
	
	public List<MusicPersisted> getMusicsPersisteds(){
		return null;
	}
	
	public void persistUser(UserPersisted user){
		
	}
	
	public void PersistMusic(MusicPersisted music){
		
	}

}
