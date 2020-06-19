package com.ebc43.bc_backend.TaskManagement.ModeloEvidenciaTarefa;


public class ModeloEvidenciaTarefaNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ModeloEvidenciaTarefaNotFoundException(Integer id) {
		super("Não foi possivel encontrar o modelo, de evidencia da tarefa, com id " + id);
	}
}