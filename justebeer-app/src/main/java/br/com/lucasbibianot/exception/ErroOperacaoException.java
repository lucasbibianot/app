package br.com.lucasbibianot.exception;

/**
 * Exception genérica de erro na operação
 * @author Lucas Bibiano
 *
 */
public class ErroOperacaoException extends Exception {

	public ErroOperacaoException(String string, Throwable e) {
		super(string, e);
	}

}
