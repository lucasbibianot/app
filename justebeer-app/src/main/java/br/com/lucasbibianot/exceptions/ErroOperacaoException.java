package br.com.lucasbibianot.exceptions;

/**
 * Exception genérica de erro na operação
 * 
 * @author Lucas Bibiano
 *
 */
public class ErroOperacaoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8346977297961529443L;

	public ErroOperacaoException(String string, Throwable e) {
		super(string, e);
	}

	public ErroOperacaoException(String string) {
		super(string);
	}

}
