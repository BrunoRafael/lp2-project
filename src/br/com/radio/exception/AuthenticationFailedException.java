package br.com.radio.exception;

public class AuthenticationFailedException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public AuthenticationFailedException(){}
	public AuthenticationFailedException(String message){
		super(message);
	}

}
