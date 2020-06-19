package com.ebc43.bc_backend.BoatManagement.Marina;

public class MarinaNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	MarinaNotFoundException(Integer id) {
		super("Não foi possivel achar uma marina com id " + id);
	}
}
