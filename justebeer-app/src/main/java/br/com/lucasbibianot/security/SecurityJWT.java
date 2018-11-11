package br.com.lucasbibianot.security;

import java.security.Key;
import java.util.Date;
import java.util.List;

import javax.crypto.spec.SecretKeySpec;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.xml.bind.DatatypeConverter;

import br.com.lucasbibianot.entidades.arquitetura.Usuario;
import br.com.lucasbibianot.exceptions.ErroOperacaoException;
import br.com.lucasbibianot.servicos.TokenSegurancaServico;
import br.com.lucasbibianot.util.Constantes;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@RequestScoped
public class SecurityJWT {

	@Inject
	private TokenSegurancaServico tokenSeguranca;

	// Sample method to construct a JWT
	private String createJWT(String id, String issuer, String subject, long ttlMillis, Usuario usuario)
			throws ErroOperacaoException {

		// The JWT signature algorithm we will be using to sign the token
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);

		// We will sign our JWT with our ApiKey secret
		byte[] apiKeySecretBytes = getSecret();
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

		// Let's set the JWT Claims
		JwtBuilder builder = Jwts.builder().setId(id).setIssuedAt(now).setSubject(subject).setIssuer(issuer)
				.signWith(signatureAlgorithm, signingKey);
		builder.claim(Constantes.TOKEN_CLAIM_MAIL, usuario.getMail());
		builder.claim(Constantes.TOKEN_CLAIM_USER_NAME, usuario.getNomeUsuario());
		builder.claim(Constantes.TOKEN_CLAIM_PERFIL, usuario.getPerfil().getId());

		// if it has been specified, let's add the expiration
		if (ttlMillis >= 0) {
			long expMillis = nowMillis + ttlMillis;
			Date exp = new Date(expMillis);
			builder.setExpiration(exp);
		}

		// Builds the JWT and serializes it to a compact, URL-safe string
		return builder.compact();
	}

	private byte[] getSecret() throws ErroOperacaoException {
		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(tokenSeguranca.getSecret());
		return apiKeySecretBytes;
	}

	/**
	 * Valida o Access Token
	 * 
	 * @param jwt
	 * @return
	 */
	public Boolean isTokenValid(String jwt) {
		try {

			// This line will throw an exception if it is not a signed JWS (as expected)
			Claims claims = Jwts.parser().setSigningKey(getSecret()).parseClaimsJws(jwt).getBody();
			return Boolean.TRUE;

		} catch (Exception e) {
			return Boolean.FALSE;
		}
	}

	/**
	 * Realiza o parser do token
	 * 
	 * @param jwt
	 * @return
	 * @throws ExpiredJwtException
	 * @throws UnsupportedJwtException
	 * @throws MalformedJwtException
	 * @throws SignatureException
	 * @throws IllegalArgumentException
	 * @throws ErroOperacaoException
	 */
	public Claims parseJWT(String jwt) throws ErroOperacaoException {
		// This line will throw an exception if it is not a signed JWS (as expected)
		return Jwts.parser().setSigningKey(getSecret()).parseClaimsJws(jwt).getBody();
	}

	/**
	 * Gera o Access Token
	 * 
	 * @param login
	 * @param ttl
	 * @param usuario
	 * @return
	 * @throws ErroOperacaoException
	 */
	public String createJWT(String login, Long ttl, Usuario usuario) throws ErroOperacaoException {
		return this.createJWT(login, Constantes.ISSUER_JUST_EBEER, login, ttl, usuario);
	}

	/**
	 * Gera o Refresh Token
	 * 
	 * @param token
	 * @return
	 * @throws ExpiredJwtException
	 * @throws UnsupportedJwtException
	 * @throws MalformedJwtException
	 * @throws SignatureException
	 * @throws IllegalArgumentException
	 * @throws ErroOperacaoException
	 */
	public String createRefreshJWT(String token) throws ErroOperacaoException {
		Jws<Claims> claims = Jwts.parser().setSigningKey(getSecret()).parseClaimsJws(token);

		List<String> scopes = claims.getBody().get("scopes", List.class);
		if (scopes == null || scopes.isEmpty() || !scopes.stream()
				.filter(scope -> Scopes.REFRESH_TOKEN.authority().equals(scope)).findFirst().isPresent()) {
			return null;
		}

		return claims.toString();
	}

	/**
	 * Cria um novo Access token utilizando o refreshtoken
	 * 
	 * @param token
	 * @param refreshToken
	 * @return
	 */
	public String createJWT(String token, String refreshToken) {
		return null;

	}

	/**
	 * Retorna um token após o seu parser
	 * 
	 * @param token
	 * @return
	 * @throws ErroOperacaoException
	 * @throws IllegalArgumentException
	 * @throws SignatureException
	 * @throws MalformedJwtException
	 * @throws UnsupportedJwtException
	 * @throws ExpiredJwtException
	 */
	public Token parseJWTToToken(String token) throws ErroOperacaoException {
		Claims claims = this.parseJWT(token);

		return new Token((String) claims.get(Constantes.TOKEN_CLAIM_MAIL),
				(String) claims.get(Constantes.TOKEN_CLAIM_USER_NAME),
				(Integer) claims.get(Constantes.TOKEN_CLAIM_PERFIL), claims.getExpiration(),
				claims.getIssuer(), claims.getSubject(), claims.getId(), claims.getIssuedAt());
	}

}
