package br.com.lucasbibianot.servicos;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.lucasbibianot.dao.RecipienteDAO;
import br.com.lucasbibianot.entidades.negocio.Recipiente;
import br.com.lucasbibianot.exceptions.MultiplusResultadosException;

@RequestScoped
public class RecipienteServico extends BaseServico {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7539570991158376112L;

	@Inject
	private RecipienteDAO recipienteDAO;

	/**
	 * Retorna o Recipiente, caso não exista, o serviço insere um novo recipiente
	 * 
	 * @return
	 * @throws MultiplusResultadosException 
	 */
	public Recipiente recuperar(Recipiente recipiente) throws MultiplusResultadosException {
		Recipiente recipienteRetorno = this.recipienteDAO.recuperar(recipiente.getVolume());
		if(recipienteRetorno == null) {
			recipiente.setAtivo("S");
			this.recipienteDAO.salvarOuAtualizar(recipiente);
			recipienteRetorno = this.recipienteDAO.recuperar(recipiente.getVolume());
		}
		
		return recipienteRetorno;
	}

}
