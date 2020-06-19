package com.ebc43.bc_backend.Security;

import org.springframework.security.core.Authentication;

import com.ebc43.bc_backend.UserManagement.TipoUsuario.TipoUsuario;

public interface IAuthenticationFacade {
	Authentication getAuthentication();

	TipoUsuario getPrincipalTipoUsuario();
}
