package com.ebc43.bc_backend.RoutineSaylor.DiaMarinheiro;

import java.util.UUID;

public class DiaMarinheiroNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	DiaMarinheiroNotFoundException(UUID id) {
		super("Não foi possivel encontrar o historico do dia do marinheiro com id " + id);
	}
}