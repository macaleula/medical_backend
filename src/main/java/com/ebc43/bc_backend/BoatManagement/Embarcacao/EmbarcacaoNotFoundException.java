package com.ebc43.bc_backend.BoatManagement.Embarcacao;

public class EmbarcacaoNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	EmbarcacaoNotFoundException(Integer id) {
		super("Não foi possivel achar a embarcação com id " + id);
	}
}