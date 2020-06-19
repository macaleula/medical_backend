package com.ebc43.bc_backend.TaskManagement.MarinheiroEscalado;

import java.util.UUID;

public class MarinheiroEscaladoNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	MarinheiroEscaladoNotFoundException(UUID id) {
		super("Não foi possivel encontrar o marinheiro_escalado com id " + id);
	}
}