package br.com.lucasbibianot.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.deltaspike.core.util.StringUtils;

import br.com.lucasbibianot.dao.FornecedorDAO;
import br.com.lucasbibianot.dto.FornecedorParamDTO;
import br.com.lucasbibianot.entidades.negocio.Fornecedor;
import br.com.lucasbibianot.exception.MultiplusResultadosException;

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

}
