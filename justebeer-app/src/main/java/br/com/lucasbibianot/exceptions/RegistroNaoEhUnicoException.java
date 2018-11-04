package br.com.lucasbibianot.exceptions;

/**
 * Exception retornada quando existe mais de um registro, quando deveria ser unico
 * @author Lucas Bibiano
 *
 */
public class RegistroNaoEhUnicoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4410470053186332037L;

	public RegistroNaoEhUnicoException(String string) {
		super(string);
	}

	public RegistroNaoEhUnicoException(String string, Throwable t) {
		super(string, t);
	}

}
