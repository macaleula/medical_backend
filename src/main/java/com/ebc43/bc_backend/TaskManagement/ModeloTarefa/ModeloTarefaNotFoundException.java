package com.ebc43.bc_backend.TaskManagement.ModeloTarefa;

public class ModeloTarefaNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ModeloTarefaNotFoundException(Integer id) {
		super("Não foi possivel encontrar o modelo da tarefa com id " + id);
	}
}