package com.ebc43.bc_backend.TaskManagement.UnidadeMedida;

public class UnidadeMedidaNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	UnidadeMedidaNotFoundException(Integer id) {
		super("Não foi possivel encontrar a unidade_medida com id " + id);
	}
}
