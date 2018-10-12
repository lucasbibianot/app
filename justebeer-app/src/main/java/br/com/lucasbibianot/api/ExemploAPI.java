package br.com.lucasbibianot.api;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.com.lucasbibianot.dao.ExemploDAO;
import br.com.lucasbibianot.dto.ExemploDTO;
import br.com.lucasbibianot.dto.ExemploEnvelopeDTO;
import br.com.lucasbibianot.entidades.Exemplo;
import br.com.lucasbibianot.security.annotations.JWTTokenNeeded;

@Path("exemplo-api")
@RequestScoped
public class ExemploAPI {

	@Inject
	private ExemploDAO dao;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/exemplo/{codigo}")
	@JWTTokenNeeded
	public ExemploDTO getExemplo(@PathParam("codigo") Long codigo) {

		Exemplo entity = dao.getExemplo(codigo);

		if (entity != null)
			return new ExemploDTO(entity.getId(), entity.getNome());

		return null;
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/exemplo")
	@JWTTokenNeeded
	public ExemploEnvelopeDTO getTodos() {
		List<ExemploDTO> listaDtos = new ArrayList<>();
		List<Exemplo> lista = dao.getTodos();

		if (lista != null) {
			for (Exemplo entity : lista) {
				listaDtos.add(new ExemploDTO(entity.getId(), entity.getNome()));
			}
			
			return new ExemploEnvelopeDTO(listaDtos);
		}
		return null;
	}

}
