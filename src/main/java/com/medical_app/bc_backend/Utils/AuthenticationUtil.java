package com.medical_app.bc_backend.Utils;

import com.medical_app.bc_backend.Security.IAuthenticationFacade;
import com.medical_app.bc_backend.Security.UsuarioDetails;

public class AuthenticationUtil {
	public static boolean isAdmin(IAuthenticationFacade authenticationFacade) {
		UsuarioDetails usuarioDetails = (UsuarioDetails) authenticationFacade.getAuthentication().getPrincipal();
		if(usuarioDetails.getTipoUsuario().getNome().equals("SI")) {
			return true;
		} else {
			return false;
		}
	}
	
	public static String getPrincipalUsername(IAuthenticationFacade authenticationFacade) {
		return ((UsuarioDetails) authenticationFacade.getAuthentication().getPrincipal()).getUsername();
	}
}
