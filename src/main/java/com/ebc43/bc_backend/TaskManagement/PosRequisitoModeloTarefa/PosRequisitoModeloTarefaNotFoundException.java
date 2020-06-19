package com.ebc43.bc_backend.TaskManagement.PosRequisitoModeloTarefa;

public class PosRequisitoModeloTarefaNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	PosRequisitoModeloTarefaNotFoundException(Integer id) {
		super("Não foi possivel encontrar o pos_requisito_modelo_tarefa com id " + id);
	}
}
