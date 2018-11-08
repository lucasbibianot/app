package br.com.lucasbibianot.api;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import br.com.lucasbibianot.dto.FornecedorEnvelopeDTO;
import br.com.lucasbibianot.security.annotations.JWTTokenNeeded;
import br.com.lucasbibianot.servicos.FornecedorServico;

@RequestScoped
@Path("fornecedor")
public class FornecedorAPI extends BaseAPI {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5496410962976807747L;

	@Inject
	private FornecedorServico fornecedorServico;

	@GET
	@JWTTokenNeeded
	public FornecedorEnvelopeDTO recuperarTodos() {
		return this.fornecedorServico.recuperarTodos();
	}

}
