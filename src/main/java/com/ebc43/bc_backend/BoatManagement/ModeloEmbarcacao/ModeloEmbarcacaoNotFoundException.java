package com.ebc43.bc_backend.BoatManagement.ModeloEmbarcacao;

public class ModeloEmbarcacaoNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	ModeloEmbarcacaoNotFoundException(Integer id) {
		super("Não foi possivel achar o modelo de embarcação com id " + id);
	}
}
