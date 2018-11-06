package br.com.lucasbibianot.security.api;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.common.net.HttpHeaders;

import br.com.lucasbibianot.security.SecurityJWT;
import br.com.lucasbibianot.servicos.ParametroServico;
import br.com.lucasbibianot.servicos.UsuarioServico;
import br.com.lucasbibianot.util.Constantes;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class UsuarioAPI {

	
	@Inject
	private SecurityJWT securityJWT;
	@Inject
	private UsuarioServico userService;
	@Inject
	private ParametroServico parametroServico;

	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response authenticateUser(@FormParam("login") String login, @FormParam("password") String password) {
		try {

			// Authenticate the user using the credentials provided
			userService.autenticar(login, password);

			// Issue a token for the user
			String token = this.securityJWT.createJWT(login, parametroServico.getParametroLong(Constantes.PARAM_TIMEOUT_TOKEN));

			// Return the token on the response
			return Response.ok().header(HttpHeaders.AUTHORIZATION, "Bearer " + token).build();

		} catch (Exception e) {
			return Response.status(Response.Status.UNAUTHORIZED).build();
		}
	}

}