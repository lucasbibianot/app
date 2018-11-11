package br.com.lucasbibianot.api;

import java.io.Serializable;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.lucasbibianot.exceptions.ErroOperacaoException;
import br.com.lucasbibianot.security.SecurityJWT;
import br.com.lucasbibianot.security.Token;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Consumes(value = MediaType.APPLICATION_JSON)
@Produces(value = MediaType.APPLICATION_JSON)
public class BaseAPI implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private SecurityJWT securityJWT;

	@HeaderParam("Authorization")
	private String token;

	public Token getToken() {
		return this.parseToken();
	}

	private Token parseToken() {
		try {
			return this.securityJWT.parseJWTToToken(this.token);
		} catch (ExpiredJwtException e) {
			e.printStackTrace();
		} catch (UnsupportedJwtException e) {
			e.printStackTrace();
		} catch (MalformedJwtException e) {
			e.printStackTrace();
		} catch (SignatureException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (ErroOperacaoException e) {
			e.printStackTrace();
		}
		return null;
	}

}
