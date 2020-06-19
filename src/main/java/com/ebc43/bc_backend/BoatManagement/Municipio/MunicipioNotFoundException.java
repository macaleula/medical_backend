package com.ebc43.bc_backend.BoatManagement.Municipio;

public class MunicipioNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	MunicipioNotFoundException(Integer id) {
		super("Não foi possivel encontrar o municipio com id " + id);
	}
}
