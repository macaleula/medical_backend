package com.ebc43.bc_backend.TaskManagement.PreRequisitoModeloTarefa;

public class PreRequisitoModeloTarefaNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	PreRequisitoModeloTarefaNotFoundException(Integer id) {
		super("Não foi possivel encontrar o pre_requisito_modelo_tarefa com id " + id);
	}
}
