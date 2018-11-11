package br.com.lucasbibianot.security.api;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.common.net.HttpHeaders;

import br.com.lucasbibianot.dto.UsuarioDTO;
import br.com.lucasbibianot.exceptions.ErroConfirmacaoSenhaException;
import br.com.lucasbibianot.exceptions.ErroOperacaoException;
import br.com.lucasbibianot.exceptions.RegistroNaoEhUnicoException;
import br.com.lucasbibianot.exceptions.UserNotAuthenticatedException;
import br.com.lucasbibianot.security.annotations.JWTTokenNeeded;
import br.com.lucasbibianot.security.annotations.RoleAdministrador;
import br.com.lucasbibianot.servicos.UsuarioServico;

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RequestScoped
public class UsuarioAPI {

	@Inject
	private UsuarioServico usuarioServico;

	@POST
	@Path("/autenticar")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response authenticateUser(@FormParam("login") String login, @FormParam("password") String password) {
		try {

			// Issue a token for the user
			String token = this.usuarioServico.gerarToken(login, password);
			String refreshToken = this.usuarioServico.gerarRefreshToken(token);
			if (token != null) {
				// Return the token on the response
				return Response.ok().header(HttpHeaders.AUTHORIZATION, "Bearer " + token)
						.header(HttpHeaders.REFRESH, refreshToken).build();
			} else {
				throw new UserNotAuthenticatedException("Erro na autenticação");
			}

		} catch (Exception e) {
			return Response.status(Response.Status.UNAUTHORIZED).build();
		}
	}

	@POST
	@Path("/novoUsuario")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response criarNovoUsuario(UsuarioDTO usuario) {
		try {
			this.usuarioServico.salvarUsuario(usuario);
			return Response.ok().build();
		} catch (ErroConfirmacaoSenhaException e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		} catch (ErroOperacaoException e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		} catch (RegistroNaoEhUnicoException e) {
			e.printStackTrace();
			return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@JWTTokenNeeded
	@RoleAdministrador
	public List<UsuarioDTO> recuperarUsuarios() {
		return this.usuarioServico.recuperar();
	}

}
