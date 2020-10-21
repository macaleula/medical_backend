package com.medical_app.bc_backend.TipoUsuario;

public class TipoUsuarioNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	TipoUsuarioNotFoundException(Integer id) {
		super("Não foi possivel encontrar o tipo de usario com id " + id);
	}
}
