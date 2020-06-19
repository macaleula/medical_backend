package com.ebc43.bc_backend.TaskManagement.ModeloAmbiente;

public class ModeloAmbienteNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ModeloAmbienteNotFoundException(Integer id) {
		super("Não foi possivel encontrar o modelo de ambiente com id " + id);
	}
}
