package com.medical_app.bc_backend.Consulta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.medical_app.bc_backend.Security.IAuthenticationFacade;

@Component
public class ConsultaServiceProvider {
	/*
	@Autowired
	ConsultaMedicoService medicoService;
	@Autowired
	ConsultaPacienteService pacienteService; */
	@Autowired
	ConsultaService service;
	
	@Autowired
	IAuthenticationFacade authenticationFacade;

	public ConsultaService getService() {
		/*if(authenticationFacade.getPrincipalTipoUsuario().getId() == 1) {
			return medicoService;
		} else if (authenticationFacade.getPrincipalTipoUsuario().getId() == 2) {
			return pacienteService;
		}
		return null;*/
		return service;
	}
}
