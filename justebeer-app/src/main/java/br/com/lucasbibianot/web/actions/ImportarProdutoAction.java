package br.com.lucasbibianot.web.actions;

import java.io.IOException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.UploadedFile;

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

	private UploadedFile file;
	
	private Integer qtdeRegistros;

	public UploadedFile getFile() {
		return file;
	}

	public void setFile(UploadedFile file) {
		this.file = file;
	}

	public void upload() {
		if (file != null) {
			this.importar();
			this.addMensagemSucesso(
					"O arquivo foi carregado com sucesso, foram processadas " + qtdeRegistros + " linhas");
		}
	}

	public void importar() {
		try {
			this.qtdeRegistros = this.produtoServico.carregarPlanilha(this.file.getInputstream());
			this.file.getInputstream().close();
		} catch (IOException e) {
			this.addMensagemErro(e.getMessage());
			e.printStackTrace();
		} catch (MultiplusResultadosException e) {
			this.addMensagemErro(e.getMessage());
			e.printStackTrace();
		}
	}

}
