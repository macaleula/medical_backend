package com.ebc43.bc_backend.RoutineSaylor.DiaSemana;

public class DiaSemanaNotFoundException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	DiaSemanaNotFoundException(Integer id) {
		super("Não foi possivel encontrar o dia da semana com id " + id);
	}
}
