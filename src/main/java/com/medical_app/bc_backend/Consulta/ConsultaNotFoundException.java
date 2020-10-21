package com.medical_app.bc_backend.Consulta;

public class ConsultaNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ConsultaNotFoundException(Integer id) {
		super("Não foi possivel encontrar a consulta com id " + id);
	}
}
