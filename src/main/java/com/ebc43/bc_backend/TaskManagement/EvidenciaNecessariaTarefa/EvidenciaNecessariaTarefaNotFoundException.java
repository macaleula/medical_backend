package com.ebc43.bc_backend.TaskManagement.EvidenciaNecessariaTarefa;

public class EvidenciaNecessariaTarefaNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	EvidenciaNecessariaTarefaNotFoundException(Integer id) {
		super("Não foi possivel encontrar a evidencia_necessaria_tarefa com id " + id);
	}
}