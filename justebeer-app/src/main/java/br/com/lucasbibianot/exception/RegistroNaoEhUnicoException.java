package br.com.lucasbibianot.exception;

/**
 * Exception retornada quando existe mais de um registro, quando deveria ser unico
 * @author Lucas Bibiano
 *
 */
public class RegistroNaoEhUnicoException extends Exception {

	public RegistroNaoEhUnicoException(String string) {
		super(string);
	}

	public RegistroNaoEhUnicoException(String string, Throwable t) {
		super(string, t);
	}

}
