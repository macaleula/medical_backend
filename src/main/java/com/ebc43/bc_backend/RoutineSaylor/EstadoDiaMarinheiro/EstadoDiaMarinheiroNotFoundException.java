package com.ebc43.bc_backend.RoutineSaylor.EstadoDiaMarinheiro;

public class EstadoDiaMarinheiroNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	EstadoDiaMarinheiroNotFoundException(Integer id) {
		super("Não foi possivel encontrar o municipio com id " + id);
	}
}