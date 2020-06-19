package com.ebc43.bc_backend.TaskManagement.AtributoEquipamento;

import java.util.UUID;

public class AtributoEquipamentoNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	AtributoEquipamentoNotFoundException(UUID id) {
		super("Não foi possivel encontrar o atributo equipamento com o id " + id);
	}
}
