package br.com.lucasbibianot.web.actions;

import java.io.IOException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.lucasbibianot.exceptions.MultiplusResultadosException;
import br.com.lucasbibianot.servicos.ProdutoServico;

@Named("importarProdutoAction")
@RequestScoped
public class ImportarProdutoAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 948844589897388295L;

	@Inject
	private ProdutoServico produtoServico;

	public void importar() {
		try {
			this.produtoServico.carregarPlanilha("C:\\Users\\Lucas Bibiano\\Downloads\\bd_produtos_rev00.xlsx");
		} catch (IOException e) {
			this.addMensagemErro(e.getMessage());
			e.printStackTrace();
		} catch (MultiplusResultadosException e) {
			this.addMensagemErro(e.getMessage());
			e.printStackTrace();
		}
	}

}
