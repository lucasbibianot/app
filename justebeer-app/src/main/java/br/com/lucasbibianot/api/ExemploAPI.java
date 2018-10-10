package br.com.lucasbibianot.api;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.lucasbibianot.dao.ExemploDAO;
import br.com.lucasbibianot.dto.ExemploDTO;
import br.com.lucasbibianot.entidades.Exemplo;

@Path("exemplo-api")
@RequestScoped
public class ExemploAPI {
	@Inject
	private ExemploDAO dao;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/fotografo/{codigo}")
	public ExemploDTO GetPessoa(@PathParam("codigo") Long codigo) {

		Exemplo entity = dao.getExemplo(codigo);

		if (entity != null)
			return new ExemploDTO(entity.getId(), entity.getNome());

		return null;
	}
}
