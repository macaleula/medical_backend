package com.ebc43.bc_backend.BoatManagement.EmbarcacaoProprietario;

public class EmbarcacaoProprietarioNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	EmbarcacaoProprietarioNotFoundException(Integer id) {
		super("Não foi possivel encontrar o embarcacao_proprietario com id " + id);
	}
}
