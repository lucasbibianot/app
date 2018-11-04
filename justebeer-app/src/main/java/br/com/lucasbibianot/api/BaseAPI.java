package br.com.lucasbibianot.api;

import java.io.Serializable;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Consumes(value = MediaType.APPLICATION_JSON)
@Produces(value = MediaType.APPLICATION_JSON)
public class BaseAPI implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
