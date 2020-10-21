package com.medical_app.bc_backend.Security;

import org.springframework.security.core.Authentication;

import com.medical_app.bc_backend.TipoUsuario.TipoUsuario;

public interface IAuthenticationFacade {
	Authentication getAuthentication();

	TipoUsuario getPrincipalTipoUsuario();
}
