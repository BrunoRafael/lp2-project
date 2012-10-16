package br.com.radio.authentication;

import java.util.Iterator;
import java.util.List;

import br.com.radio.exception.AuthenticationFailedException;
import br.com.radio.persistence.PersistenceManager;
import br.com.radio.persistence.UserPersisted;

public class Authentication {
	private PersistenceManager persistence;
	
	public Authentication(){
		persistence = new PersistenceManager();
	}
	
	public boolean authenticate(String login, String password)
			throws AuthenticationFailedException{
		
		List<UserPersisted> users = persistence.getUsersRegistereds();
		Iterator<UserPersisted> it = users.iterator();
		
		while(it.hasNext()){
			UserPersisted user = it.next();
			
			if(user.getEmail().equals(login) && 
			   user.getPassword().equals(password))
			   
			   return true;
		}
		
		return false;
	}
}
