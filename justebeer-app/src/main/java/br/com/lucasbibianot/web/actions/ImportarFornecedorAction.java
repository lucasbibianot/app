package br.com.lucasbibianot.web.actions;

import java.io.IOException;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.UploadedFile;

import br.com.lucasbibianot.exceptions.MultiplusResultadosException;
import br.com.lucasbibianot.servicos.FornecedorServico;

@Named("importarFornecedorAction")
@RequestScoped
public class ImportarFornecedorAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3214413375802398650L;

	@Inject
	private FornecedorServico fornecedorServico;

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

	private void importar() {
		try {
			this.qtdeRegistros = this.fornecedorServico.carregarPlanilha(this.file.getInputstream());
		} catch (IOException e) {
			this.addMensagemErro(e.getMessage());
			e.printStackTrace();
		} catch (MultiplusResultadosException e) {
			this.addMensagemErro(e.getMessage());
			e.printStackTrace();
		}
	}

}
