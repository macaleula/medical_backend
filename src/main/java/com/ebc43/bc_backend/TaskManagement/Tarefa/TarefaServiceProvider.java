package com.ebc43.bc_backend.TaskManagement.Tarefa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ebc43.bc_backend.Security.IAuthenticationFacade;

@Component
public class TarefaServiceProvider {
	@Autowired
	TarefaSiService siService;
	@Autowired
	TarefaPrService prService;
	@Autowired
	TarefaMrService mrService;
	
	@Autowired
	IAuthenticationFacade authenticationFacade;

	public TarefaService getService() {
		if(authenticationFacade.getPrincipalTipoUsuario().getId() == 1) {
			return siService;
		} else if (authenticationFacade.getPrincipalTipoUsuario().getId() == 2) {
			return prService;
		} else if (authenticationFacade.getPrincipalTipoUsuario().getId() == 3) {
			return mrService;
		}
		return null;
	}
}
