package com.ebc43.bc_backend.TaskManagement.RecursoHumanoModeloTarefa;


public class RecursoHumanoModeloTarefaNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	RecursoHumanoModeloTarefaNotFoundException(Integer id) {
		super("Não foi possivel encontrar a recurso_humano_modelo_tarefa com o id " + id);
	}

}
