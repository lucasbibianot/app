package br.com.lucasbibianot.exceptions;

/**
 * Exception, quando a senha e sua confirmação não corresponderem
 * @author Lucas Bibiano
 *
 */
public class ErroConfirmacaoSenhaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2863122001883291021L;

	public ErroConfirmacaoSenhaException(String msg) {
		super(msg);
	}

	public ErroConfirmacaoSenhaException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

}
