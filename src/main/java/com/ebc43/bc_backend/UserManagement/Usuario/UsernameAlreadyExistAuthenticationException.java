package com.ebc43.bc_backend.UserManagement.Usuario;

public class UsernameAlreadyExistAuthenticationException extends RuntimeException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -19528849095806384L;

	public UsernameAlreadyExistAuthenticationException(final String username) {
        super("O usuario: " + username + " já existe.");
    }

}