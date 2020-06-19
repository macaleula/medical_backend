package com.ebc43.bc_backend.TaskManagement.PropriedadeModeloEquipamento;

public class PropriedadeModeloEquipamentoNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	PropriedadeModeloEquipamentoNotFoundException(Integer id) {
		super("Não foi possivel encontrar a propriedade_modelo_equipamento com id " + id);
	}
}