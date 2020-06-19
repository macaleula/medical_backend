package com.ebc43.bc_backend.TaskManagement.ModeloEquipamento;

public class ModeloEquipamentoNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ModeloEquipamentoNotFoundException(Integer id) {
		super("Não foi possivel encontrar o modelo, de equipamento, com id " + id);
	}
}
