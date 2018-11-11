package br.com.lucasbibianot.security.filters;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Priority;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import br.com.lucasbibianot.exceptions.ErroOperacaoException;
import br.com.lucasbibianot.security.SecurityJWT;
import br.com.lucasbibianot.security.Token;
import br.com.lucasbibianot.security.annotations.RoleAdministrador;
import br.com.lucasbibianot.servicos.ParametroServico;
import br.com.lucasbibianot.util.Constantes;

@Provider
@RoleAdministrador
@Priority(Priorities.AUTHORIZATION)
@RequestScoped
public class RoleAdministradorFilter implements ContainerRequestFilter {

	private static final Logger logger = Logger.getLogger("RoleAdministradorFilter");

	@Inject
	private SecurityJWT securityJWT;

	@Inject
	private ParametroServico parametroServico;

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		// Get the HTTP Authorization header from the request
		String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
		if (authorizationHeader != null) {
			Long idParametroAdm = this.parametroServico.getParametroLong(Constantes.PARAM_ID_PERFIL_ADM);
			// Extract the token from the HTTP Authorization header
			Token token = null;
			try {
				token = this.securityJWT.parseJWTToToken(authorizationHeader.substring("Bearer".length()).trim());
			} catch (ErroOperacaoException e) {
				logger.log(Level.SEVERE, "Erro ao realizar o parser do Token", e);
			}
			if (idParametroAdm.equals(token.getIdPerfilUsuario().longValue())) {

			} else {
				requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
			}
		} else {
			requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
		}
	}
}