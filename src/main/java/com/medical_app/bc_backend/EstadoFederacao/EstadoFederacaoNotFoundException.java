package com.medical_app.bc_backend.EstadoFederacao;

public class EstadoFederacaoNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	EstadoFederacaoNotFoundException(Integer id) {
		super("Não foi possivel achar o estado_federacao com id " + id);
	}
}
