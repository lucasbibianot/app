package br.com.lucasbibianot.exception;

/**
 * Exception, quando a senha e sua confirmação não corresponderem
 * @author Lucas Bibiano
 *
 */
public class ErroConfirmacaoSenhaException extends Exception {

	public ErroConfirmacaoSenhaException(String msg) {
		super(msg);
	}

	public ErroConfirmacaoSenhaException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

}
