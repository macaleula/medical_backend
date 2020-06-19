package com.ebc43.bc_backend.TaskManagement.InterdicaoEquipamento;

import java.util.UUID;

public class InterdicaoEquipamentoNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	InterdicaoEquipamentoNotFoundException(UUID id) {
		super("Não foi possivel encontrar a interdicao_ambiente com id " + id);
	}
}
