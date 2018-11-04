package br.com.lucasbibianot.servicos;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import br.com.lucasbibianot.dao.ParametroDAO;
import br.com.lucasbibianot.entidades.arquitetura.Parametro;
import br.com.lucasbibianot.exceptions.MultiplusResultadosException;

@RequestScoped
public class ParametroServico extends BaseServico {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7688025149884733358L;

	@Inject
	private ParametroDAO parametroDAO;

	/**
	 * Retorna um parâmetro que seja numérico
	 * 
	 * @param nome
	 * @return
	 */
	public Long getParametroLong(String nome) {
		try {
			return "N".equals(getParametro(nome).getTipoParametro())
					? Long.parseLong(getParametro(nome).getValParametro())
					: null;
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Retorna um parâmetro que seja data
	 * 
	 * @param nome
	 * @return
	 */
	public Date getParametroData(String nome) {

		DateFormat format = new SimpleDateFormat();

		try {
			return "D".equals(getParametro(nome).getTipoParametro())
					? format.parse(getParametro(nome).getValParametro())
					: null;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Retorna um parâmetro que seja string
	 * 
	 * @param nome
	 * @return
	 */
	public String getParametroString(String nome) {
		return "S".equals(getParametro(nome).getTipoParametro()) ? getParametro(nome).getValParametro() : null;
	}

	private Parametro getParametro(String nome) {
		Parametro parametro = null;
		try {
			parametro = this.parametroDAO.getParametro(nome);
		} catch (MultiplusResultadosException e) {
			e.printStackTrace();
		}
		return parametro;
	}

}
