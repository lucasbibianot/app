package br.com.lucasbibianot.servicos;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Iterator;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import br.com.lucasbibianot.dao.ProdutoDAO;
import br.com.lucasbibianot.entidades.negocio.Produto;
import br.com.lucasbibianot.entidades.negocio.Recipiente;
import br.com.lucasbibianot.exceptions.MultiplusResultadosException;
import br.com.lucasbibianot.util.ExcelUtil;

@RequestScoped
public class ProdutoServico extends BaseServico {

	/**
	 * 
	 */
	private static final long serialVersionUID = 900316698953166450L;

	@Inject
	private ProdutoDAO produtoDAO;
	@Inject
	private RecipienteServico recipienteServico;

	/**
	 * Carrega a lista de produtos da planilha
	 * 
	 * @param fileName
	 * @throws IOException
	 * @throws MultiplusResultadosException
	 */
	public void carregarPlanilha(String fileName) throws IOException, MultiplusResultadosException {
		int startRow = 5;
		int countRow = 1;

		Iterator<Row> rowIterator = ExcelUtil.abrirPlanilha(fileName, 0).iterator();
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			if (countRow >= startRow) {
				this.salvar(this.parserLinha(row));
			}
			countRow++;
		}
	}

	/**
	 * TODO refatorar esses métodos
	 * 
	 * @param file
	 * @throws IOException
	 * @throws MultiplusResultadosException
	 */
	public void carregarPlanilha(InputStream file) throws IOException, MultiplusResultadosException {
		int startRow = 5;
		int countRow = 1;
		Iterator<Row> rowIterator = ExcelUtil.abrirPlanilha(file, 0).iterator();
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			if (countRow >= startRow) {
				this.salvar(this.parserLinha(row));
			}
			countRow++;
		}
	}

	/**
	 * Persiste um produto
	 * 
	 * @param produto
	 * @throws MultiplusResultadosException
	 */
	public void salvar(Produto produto) throws MultiplusResultadosException {
		if (produto != null && !this.produtoExistente(produto)) {
			produto.setAtivo("S");
			this.produtoDAO.salvarOuAtualizar(produto);
		}
	}

	private boolean produtoExistente(Produto produto) throws MultiplusResultadosException {
		return this.produtoDAO.recuperar(produto.getNomeProduto(), produto.getRecipiente().getVolume()) != null;
	}

	private Produto parserLinha(Row row) throws MultiplusResultadosException {
		Produto produto = new Produto();
		int countCol = 1;
		int startCollumn = 2;
		int endCollumn = 7;
		Iterator<Cell> cellIterator = row.cellIterator();
		Recipiente recipiente = new Recipiente();
		while (cellIterator.hasNext()) {
			Cell cell = cellIterator.next();
			if (countCol >= startCollumn && countCol <= endCollumn) {
				this.preencherProduto(produto, cell, countCol, recipiente);
			}
			countCol++;
		}
		produto.setRecipiente(this.recipienteServico.recuperar(recipiente));
		return produto;
	}

	private void preencherProduto(Produto produto, Cell cell, int countCol, Recipiente recipiente)
			throws MultiplusResultadosException {
		Object valor = ExcelUtil.recuperarValorCelula(cell);
		if (valor != null) {
			switch (countCol) {
			case 2:
				produto.setNomeProduto((String) valor);
				break;
			case 6:
				recipiente.setNome((String) valor);
				break;
			case 7:
				recipiente.setVolume(BigDecimal.valueOf((Double) valor));
			}
		}
	}

}
