package com.ebc43.bc_backend.TaskManagement.UsuarioEtapaTarefaVista;

import java.util.UUID;

public class UsuarioEtapaTarefaVistaNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	UsuarioEtapaTarefaVistaNotFoundException(UUID id) {
		super("Não foi possivel encontrar o usuario_etapa_tarefa_vista com o id " + id);
	}
}