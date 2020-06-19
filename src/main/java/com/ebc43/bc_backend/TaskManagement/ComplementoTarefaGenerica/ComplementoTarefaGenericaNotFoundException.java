package com.ebc43.bc_backend.TaskManagement.ComplementoTarefaGenerica;

import java.util.UUID;

public class ComplementoTarefaGenericaNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ComplementoTarefaGenericaNotFoundException(UUID id) {
		super("Não foi possivel encontrar a complemento_tarefa_generica com o id " + id);
	}
}
