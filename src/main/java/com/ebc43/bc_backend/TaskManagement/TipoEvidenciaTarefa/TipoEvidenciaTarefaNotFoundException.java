package com.ebc43.bc_backend.TaskManagement.TipoEvidenciaTarefa;

public class TipoEvidenciaTarefaNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	TipoEvidenciaTarefaNotFoundException(Integer id) {
		super("Não foi possivel encontrar o tipo_evidencia_tarefa com id " + id);
	}
}
