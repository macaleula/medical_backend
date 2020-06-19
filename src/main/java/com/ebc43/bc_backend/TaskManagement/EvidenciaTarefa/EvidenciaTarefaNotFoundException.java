package com.ebc43.bc_backend.TaskManagement.EvidenciaTarefa;

import java.util.UUID;

public class EvidenciaTarefaNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	EvidenciaTarefaNotFoundException(UUID id) {
		super("Não foi possivel encontrar a evidencia_tarefa com id " + id);
	}
}