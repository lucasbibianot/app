package br.com.lucasbibianot.service;

import javax.enterprise.context.RequestScoped;

import br.com.lucasbibianot.exception.UserNotAuthenticatedException;

@RequestScoped
public class UserService {

	//TODO
	public Boolean autenticar(String login, String senha) throws UserNotAuthenticatedException {
		return Boolean.TRUE;
	}
	
}
