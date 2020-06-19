package com.ebc43.bc_backend.TaskManagement.IntegranteGrupoTarefa;

import java.util.UUID;

public class IntegranteGrupoTarefaNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	IntegranteGrupoTarefaNotFoundException(UUID id) {
		super("Não foi possivel encontrar o integrante_grupo_tarefa com o id " + id);
	}
}
