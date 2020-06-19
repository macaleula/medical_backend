package com.ebc43.bc_backend.RoutineSaylor.EscalaDiaTrabalho;

import java.util.UUID;

public class EscalaDiaTrabalhoNotFoundException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	EscalaDiaTrabalhoNotFoundException(UUID id) {
		super("Não foi possivel encontrar a escala_dia_trabalho com o id " + id);
	}
}
