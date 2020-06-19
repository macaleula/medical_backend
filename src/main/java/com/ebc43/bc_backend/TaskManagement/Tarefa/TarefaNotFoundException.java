package com.ebc43.bc_backend.TaskManagement.Tarefa;

import java.util.UUID;

public class TarefaNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	TarefaNotFoundException(UUID id) {
		super("Não foi possivel encontrar a tarefa com o id " + id);
	}
}
