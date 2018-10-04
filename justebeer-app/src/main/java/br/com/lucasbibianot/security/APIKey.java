package br.com.lucasbibianot.security;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class APIKey {

	private String secretKey = "TGlsaWFueUZvdG9ncmFmaWE=";

	public String getSecretKey() {
		return secretKey;
	}

}
