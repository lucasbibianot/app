package br.com.lucasbibianot.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Criptografia {

	private static final int SALT_BYTE_SIZE = 20;
	private static final String CHARSET_UTF_8 = "UTF-8";
	private static final String HASH_ALGORITHM_SHA_256 = "SHA-256";

	public static String criptografar(String texto) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest algorithm = MessageDigest.getInstance(HASH_ALGORITHM_SHA_256);
		byte messageDigest[] = algorithm.digest(texto.getBytes(CHARSET_UTF_8));

		StringBuilder hexString = new StringBuilder();
		for (byte b : messageDigest) {
			hexString.append(String.format("%02X", 0xFF & b));
		}
		return hexString.toString();
	}

	public String getSalt() {
		SecureRandom random = new SecureRandom();
		byte bytes[] = new byte[SALT_BYTE_SIZE];
		random.nextBytes(bytes);
		return new String(bytes);
	}

}
