package br.com.lucasbibianot.servicos;

import java.io.IOException;
import java.util.Iterator;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import br.com.lucasbibianot.dao.ProdutoDAO;
import br.com.lucasbibianot.dao.RecipienteDAO;
import br.com.lucasbibianot.entidades.negocio.Produto;
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
	private RecipienteDAO recipienteDAO;

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
	 * Persiste um produto
	 * 
	 * @param produto
	 */
	public void salvar(Produto produto) {
		if (produto != null) {
			produto.setAtivo("S");
			this.produtoDAO.salvarOuAtualizar(produto);
		}
	}

	private Produto parserLinha(Row row) throws MultiplusResultadosException {
		Produto produto = new Produto();
		int countCol = 1;
		int startCollumn = 2;
		int endCollumn = 6;
		Iterator<Cell> cellIterator = row.cellIterator();
		while (cellIterator.hasNext()) {
			Cell cell = cellIterator.next();
			if (countCol >= startCollumn && countCol <= endCollumn) {
				this.preencherProduto(produto, cell, countCol);
			}
			countCol++;
		}
		return produto;
	}

	private void preencherProduto(Produto produto, Cell cell, int countCol) throws MultiplusResultadosException {
		Object valor = ExcelUtil.recuperarValorCelula(cell);
		if (valor != null) {
			switch (countCol) {
			case 2:
				produto.setNomeProduto((String) valor);
				break;
			case 6:
				produto.setRecipiente(this.recipienteDAO.recuperar((String) valor));
			}
		}
	}

}
