package com.ebc43.bc_backend.TaskManagement.GrupoTarefa;

import java.util.UUID;

public class GrupoTarefaNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	GrupoTarefaNotFoundException(UUID id) {
		super("Não foi possivel encontrar o grupo_tarefa com o id " + id);
	}
}
