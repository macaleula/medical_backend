package com.medical_app.bc_backend.Consulta;

import java.util.List;

import org.springframework.stereotype.Service;

import com.medical_app.bc_backend.Utils.AuthenticationUtil;

@Service
public class ConsultaMedicoService extends ConsultaService {

	public ConsultaMedicoService(ConsultaRepository repository) {
		super(repository);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	List<Consulta> all() {
		return super.getRepository().findAllByMedicoUsername(AuthenticationUtil.getPrincipalUsername(super.getAuthenticationFacade()));
	}

}
