package com.ebc43.bc_backend.UserManagement.InformacoesSensiveis;

public class InformacoesSensiveisNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	InformacoesSensiveisNotFoundException(Integer id) {
		super("Não foi possivel encontrar informações sensiveis com id " + id);
	}
}