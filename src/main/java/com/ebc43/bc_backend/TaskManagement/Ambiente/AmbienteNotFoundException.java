package com.ebc43.bc_backend.TaskManagement.Ambiente;

public class AmbienteNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	AmbienteNotFoundException(Integer id) {
		super("Não foi possivel encontrar o ambiente com id " + id);
	}
}
