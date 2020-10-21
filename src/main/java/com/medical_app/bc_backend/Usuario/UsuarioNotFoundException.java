package com.medical_app.bc_backend.Usuario;

public class UsuarioNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	UsuarioNotFoundException(Integer id) {
		super("Não foi possivel encontrar o usuario com id " + id);
	}

	public UsuarioNotFoundException(String username) {
		super("Não foi possivel encontrar o usuario com username " + username);
	}
}