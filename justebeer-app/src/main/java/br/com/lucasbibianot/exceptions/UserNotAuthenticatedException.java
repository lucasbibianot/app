package br.com.lucasbibianot.exceptions;

public class UserNotAuthenticatedException extends Exception {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7036923411191646025L;

	public UserNotAuthenticatedException(String msg, Throwable throwable) {
		super(msg, throwable);
	}
	
	public UserNotAuthenticatedException(String msg) {
		super(msg);
	}
	
	
}
