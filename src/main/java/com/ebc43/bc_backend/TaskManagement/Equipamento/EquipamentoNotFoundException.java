package com.ebc43.bc_backend.TaskManagement.Equipamento;

import java.util.UUID;

public class EquipamentoNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	EquipamentoNotFoundException(UUID id) {
		super("Não foi possivel encontrar o equipamento com id " + id);
	}
}