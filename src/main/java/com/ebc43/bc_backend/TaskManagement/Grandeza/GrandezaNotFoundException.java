package com.ebc43.bc_backend.TaskManagement.Grandeza;

public class GrandezaNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	GrandezaNotFoundException(Integer id) {
		super("Não foi possivel encontrar a grandeza com id " + id);
	}
}
