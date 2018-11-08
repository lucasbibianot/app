package br.com.lucasbibianot.servicos;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import org.apache.deltaspike.core.util.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import br.com.lucasbibianot.dao.FornecedorDAO;
import br.com.lucasbibianot.dto.FornecedorDTO;
import br.com.lucasbibianot.dto.FornecedorEnvelopeDTO;
import br.com.lucasbibianot.dto.FornecedorParamDTO;
import br.com.lucasbibianot.entidades.negocio.Fornecedor;
import br.com.lucasbibianot.exceptions.MultiplusResultadosException;
import br.com.lucasbibianot.util.ExcelUtil;

@RequestScoped
public class FornecedorServico extends BaseServico {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1490441836713385698L;

	@Inject
	private FornecedorDAO fornecedorDAO;

	/**
	 * Realiza a busca do fornecedor, de acordo com algum dos parametros do DTO Caso
	 * seja informado o placeId ele será utilizado, caso contrário, sera utilizada a
	 * latitude e a longitude
	 * 
	 * @param fornecedorParamDTO
	 * @return
	 * @throws MultiplusResultadosException
	 */
	public List<Fornecedor> recuperar(FornecedorParamDTO fornecedorParamDTO) throws MultiplusResultadosException {
		List<Fornecedor> fornecedores = new ArrayList<Fornecedor>();
		if (fornecedorParamDTO != null && StringUtils.isNotEmpty(fornecedorParamDTO.getPlaceID())) {

			Fornecedor fornecedor = this.fornecedorDAO.recuperar(fornecedorParamDTO.getPlaceID());
			if (fornecedor != null) {
				fornecedores.add(fornecedor);
			}

		} else if (fornecedorParamDTO != null && fornecedorParamDTO.getLatitude() != null
				&& fornecedorParamDTO.getLongitude() != null) {
			return this.fornecedorDAO.recuperar(fornecedorParamDTO.getLatitude(), fornecedorParamDTO.getLongitude());
		}
		return fornecedores;

	}
	
	/**
	 * Retorna a lista de fornecedores 
	 * @return
	 */
	public FornecedorEnvelopeDTO recuperarTodos() {
		FornecedorEnvelopeDTO envelopeDTO = new FornecedorEnvelopeDTO();
		List<FornecedorDTO> lista = new ArrayList<FornecedorDTO>();
		for(Fornecedor fornecedor : this.fornecedorDAO.recuperarTodos(Fornecedor.class)) {
			FornecedorDTO dto = new FornecedorDTO(fornecedor);
			lista.add(dto);
		}
		envelopeDTO.setFornecedores(lista);
		return envelopeDTO;
	}
	

	/**
	 * Carrega a planilha com os fornecedores existentes
	 * 
	 * @param inputstream
	 * @throws IOException
	 * @throws MultiplusResultadosException
	 */
	public Integer carregarPlanilha(InputStream inputstream) throws IOException, MultiplusResultadosException {
		int startRow = 2;
		int countRow = 1;

		Iterator<Row> rowIterator = ExcelUtil.abrirPlanilha(inputstream, 0).iterator();
		while (rowIterator.hasNext()) {
			Row row = rowIterator.next();
			if (countRow >= startRow) {
				this.salvar(this.parserLinha(row));
			}
			countRow++;
		}
		
		return countRow;

	}

	/**
	 * Insere ou atualiza o fornecedor
	 * 
	 * @param fornecedor
	 * @throws MultiplusResultadosException
	 */
	public void salvar(Fornecedor fornecedor) throws MultiplusResultadosException {
		if (fornecedor != null && !this.fornecedorExistente(fornecedor)) {
			fornecedor.setAtivo("S");
			this.fornecedorDAO.salvarOuAtualizar(fornecedor);
		} else {
			System.out.println("O fornecedor " + fornecedor.getIdentificador() + " não foi cadastrado");
		}
	}

	/**
	 * Verificar se já existe um mesmo fornecedor pelo identificador
	 * 
	 * @param fornecedor
	 * @return
	 * @throws MultiplusResultadosException
	 */
	private boolean fornecedorExistente(Fornecedor fornecedor) throws MultiplusResultadosException {
		return this.fornecedorDAO.recuperarPeloIdentificador(fornecedor.getIdentificador()) != null;

	}

	/**
	 * Realiza o parser da tabela
	 * 
	 * @param row
	 * @return
	 */
	private Fornecedor parserLinha(Row row) {
		Fornecedor fornecedor = new Fornecedor();
		int countCol = 1;
		int startCollumn = 1;
		int endCollumn = 15;
		Iterator<Cell> cellIterator = row.cellIterator();
		while (cellIterator.hasNext()) {
			Cell cell = cellIterator.next();
			if (countCol >= startCollumn && countCol <= endCollumn) {
				this.preencherFornecedor(fornecedor, cell, countCol);
			}
			countCol++;
		}
		return fornecedor;
	}

	/**
	 * Monta e preenche o objeto fornecedor
	 * 
	 * @param fornecedor
	 * @param cell
	 * @param countCol
	 */
	private void preencherFornecedor(Fornecedor fornecedor, Cell cell, int countCol) {
		Object valor = ExcelUtil.recuperarValorCelula(cell);
		if (valor != null) {
			switch (countCol) {
			case 1:
				fornecedor.setNomeFornecedor((String) valor);
				break;
			case 2:
				fornecedor.setReferencia((String) valor);
				break;
			case 4:
				fornecedor.setRua((String) valor);
				break;
			case 5:
				fornecedor.setNumero(((Double) valor).intValue());
				break;
			case 6:
				fornecedor.setComplemento((String) valor);
				break;
			case 7:
				fornecedor.setBairro((String) valor);
				break;
			case 8:
				fornecedor.setCep(Integer.parseInt(((String) valor).replace("-", "")));
				break;
			case 9:
				fornecedor.setCidade((String) valor);
				break;
			case 10:
				fornecedor.setUf((String) valor);
				break;
			case 11:
				fornecedor.setEndereco((String) valor);
				break;
			case 12:
				fornecedor.setIdentificador((String) valor);
				break;
			case 13:
				fornecedor.setTelefone((String) valor);
				break;
			case 14:
				fornecedor.setContatoTel((String) valor);
				break;
			case 15:
				fornecedor.setEmail((String) valor);
				break;
			case 16:
				fornecedor.setContatoEMail((String) valor);
				break;
			}
		}

	}

}
