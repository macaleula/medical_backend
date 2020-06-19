package com.ebc43.bc_backend.TaskManagement.EtapaTarefa;

import java.util.UUID;

public class EtapaTarefaNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	EtapaTarefaNotFoundException(UUID id) {
		super("Não foi possivel encontrar a etapa de execucao da tarefa com id " + id);
	}
}
