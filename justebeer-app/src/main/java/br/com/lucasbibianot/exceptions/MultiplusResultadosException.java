package br.com.lucasbibianot.exceptions;

public class MultiplusResultadosException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 169464101263415578L;

	public MultiplusResultadosException() {
		super();
	}

	public MultiplusResultadosException(String causa, Throwable throwable) {
		super(causa, throwable);
	}

}
