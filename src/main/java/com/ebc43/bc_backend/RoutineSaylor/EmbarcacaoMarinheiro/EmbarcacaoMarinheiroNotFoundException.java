package com.ebc43.bc_backend.RoutineSaylor.EmbarcacaoMarinheiro;

public class EmbarcacaoMarinheiroNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	EmbarcacaoMarinheiroNotFoundException(Integer id) {
		super("Não foi possivel encontrar a relação entre marinheiro e embarcação com id " + id);
	}
}
