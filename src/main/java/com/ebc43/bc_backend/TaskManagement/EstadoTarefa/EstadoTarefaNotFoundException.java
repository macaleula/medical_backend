package com.ebc43.bc_backend.TaskManagement.EstadoTarefa;

public class EstadoTarefaNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	EstadoTarefaNotFoundException(Integer id) {
		super("Não foi possivel encontrar o estado da tarefa com id " + id);
	}
}