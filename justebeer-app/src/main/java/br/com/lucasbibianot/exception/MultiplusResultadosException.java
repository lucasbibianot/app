package br.com.lucasbibianot.exception;

public class MultiplusResultadosException extends Exception {

	public MultiplusResultadosException() {
		super();
	}

	public MultiplusResultadosException(String causa, Throwable throwable) {
		super(causa, throwable);
	}

}
