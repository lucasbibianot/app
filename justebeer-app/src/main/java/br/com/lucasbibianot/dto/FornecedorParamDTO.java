package br.com.lucasbibianot.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class FornecedorParamDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4529579053250422406L;

	private BigDecimal latitude;
	private BigDecimal longitude;
	private String placeID;

	public FornecedorParamDTO() {
		super();
	}

	public FornecedorParamDTO(BigDecimal latitude, BigDecimal longitude, String placeID) {
		super();
		this.latitude = latitude;
		this.longitude = longitude;
		this.placeID = placeID;
	}

	public BigDecimal getLatitude() {
		return latitude;
	}

	public void setLatitude(BigDecimal latitude) {
		this.latitude = latitude;
	}

	public BigDecimal getLongitude() {
		return longitude;
	}

	public void setLongitude(BigDecimal longitude) {
		this.longitude = longitude;
	}

	public String getPlaceID() {
		return placeID;
	}

	public void setPlaceID(String placeID) {
		this.placeID = placeID;
	}

}
