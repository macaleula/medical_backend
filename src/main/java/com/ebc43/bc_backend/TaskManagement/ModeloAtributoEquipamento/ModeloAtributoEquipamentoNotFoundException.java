package com.ebc43.bc_backend.TaskManagement.ModeloAtributoEquipamento;

public class ModeloAtributoEquipamentoNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ModeloAtributoEquipamentoNotFoundException(Integer id) {
		super("Não foi possivel encontrar o modelo atributos do equipamento com id " + id);
	}
}
