package com.medical_app.bc_backend.Municipio;

public class MunicipioNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	MunicipioNotFoundException(Integer id) {
		super("Não foi possivel encontrar o municipio com id " + id);
	}
}
