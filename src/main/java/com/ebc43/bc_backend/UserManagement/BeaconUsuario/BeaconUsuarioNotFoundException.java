package com.ebc43.bc_backend.UserManagement.BeaconUsuario;

public class BeaconUsuarioNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	BeaconUsuarioNotFoundException(Integer id) {
		super("Não foi possivel encontrar o beacon_usuario com id " + id);
	}
}
