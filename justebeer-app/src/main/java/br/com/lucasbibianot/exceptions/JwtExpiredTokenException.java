package br.com.lucasbibianot.exceptions;

public class JwtExpiredTokenException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6785418971045451697L;

	public JwtExpiredTokenException() {
		super();
	}

	public JwtExpiredTokenException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public JwtExpiredTokenException(String message) {
		super(message);
	}

	public JwtExpiredTokenException(Throwable cause) {
		super(cause);
	}

}
