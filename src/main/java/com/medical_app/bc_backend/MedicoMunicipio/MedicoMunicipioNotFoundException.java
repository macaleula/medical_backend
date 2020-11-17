package com.medical_app.bc_backend.MedicoMunicipio;

public class MedicoMunicipioNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	MedicoMunicipioNotFoundException(Integer id) {
		super("Não foi possivel encontrar o medico_municipio com id " + id);
	}
}
