package com.ebc43.bc_backend.TaskManagement.InterdicaoAmbiente;

import java.util.UUID;

public class InterdicaoAmbienteNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	InterdicaoAmbienteNotFoundException(UUID id) {
		super("Não foi possivel encontrar a interdicao_ambiente com id " + id);
	}
}
