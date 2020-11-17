package com.medical_app.bc_backend.Consulta;

import java.util.List;

import org.springframework.stereotype.Service;

import com.medical_app.bc_backend.Utils.AuthenticationUtil;

@Service
public class ConsultaPacienteService extends ConsultaService{

	public ConsultaPacienteService(ConsultaRepository repository) {
		super(repository);
		// TODO Auto-generated constructor stub
	}

	@Override
	List<Consulta> all() {
		return super.getRepository().findAllByPacienteUsername(AuthenticationUtil.getPrincipalUsername(super.getAuthenticationFacade()));
	}
	
	

}
