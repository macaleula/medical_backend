package com.ebc43.bc_backend.Security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.ebc43.bc_backend.UserManagement.TipoUsuario.TipoUsuario;

@Component
public class AuthenticationFacade implements IAuthenticationFacade{

	@Override
	public Authentication getAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}

	@Override
	public TipoUsuario getPrincipalTipoUsuario() {
		return ((UsuarioDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getTipoUsuario();
	}

}
