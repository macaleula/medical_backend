package com.ebc43.bc_backend.BoatManagement.EstadoFederacao;

public class EstadoFederacaoNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	EstadoFederacaoNotFoundException(Integer id) {
		super("Não foi possivel achar o estado com id " + id);
	}
}
