package br.com.lucasbibianot.security;

import java.security.Key;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.xml.bind.DatatypeConverter;

import br.com.lucasbibianot.exceptions.ErroOperacaoException;
import br.com.lucasbibianot.servicos.TokenSegurancaServico;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
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
	private String createJWT(String id, String issuer, String subject, long ttlMillis) throws ErroOperacaoException {

		// The JWT signature algorithm we will be using to sign the token
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);

		// We will sign our JWT with our ApiKey secret
		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(tokenSeguranca.getSecret());
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

		// Let's set the JWT Claims
		JwtBuilder builder = Jwts.builder().setId(id).setIssuedAt(now).setSubject(subject).setIssuer(issuer)
				.signWith(signatureAlgorithm, signingKey);

		// if it has been specified, let's add the expiration
		if (ttlMillis >= 0) {
			long expMillis = nowMillis + ttlMillis;
			Date exp = new Date(expMillis);
			builder.setExpiration(exp);
		}

		// Builds the JWT and serializes it to a compact, URL-safe string
		return builder.compact();
	}

	public Boolean isTokenValid(String jwt) {
		try {

			// This line will throw an exception if it is not a signed JWS (as expected)
			Claims claims = Jwts.parser()
					.setSigningKey(DatatypeConverter.parseBase64Binary(tokenSeguranca.getSecret()))
					.parseClaimsJws(jwt).getBody();
			return Boolean.TRUE;

		} catch (Exception e) {
			return Boolean.FALSE;
		}
	}

	private void parseJWT(String jwt) throws ExpiredJwtException, UnsupportedJwtException, MalformedJwtException, SignatureException, IllegalArgumentException, ErroOperacaoException {

		// This line will throw an exception if it is not a signed JWS (as expected)
		Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(tokenSeguranca.getSecret()))
				.parseClaimsJws(jwt).getBody();

		System.out.println("ID: " + claims.getId());
		System.out.println("Subject: " + claims.getSubject());
		System.out.println("Issuer: " + claims.getIssuer());
		System.out.println("Expiration: " + claims.getExpiration());
	}


	public String createJWT(String login, Long ttl) throws ErroOperacaoException {
		return this.createJWT(login, "localHost", login, ttl);
	}
}
