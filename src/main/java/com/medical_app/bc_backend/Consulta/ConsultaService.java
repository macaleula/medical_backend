package com.medical_app.bc_backend.Consulta;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.medical_app.bc_backend.Security.IAuthenticationFacade;

@Service
public class ConsultaService {
	@Autowired
    private IAuthenticationFacade authenticationFacade;
	
	private final ConsultaRepository repository;

	public ConsultaService(ConsultaRepository repository) {
		this.repository = repository;
	}

	List<Consulta> all() {
		return (List<Consulta>) repository.findAll();
	}

	Consulta newConsulta(Consulta newEntity) {
	    return repository.save(newEntity);
    }

	Consulta one(Integer id) {
		return repository.findById(id)
				.orElseThrow(() -> new ConsultaNotFoundException(id));
	}

	Consulta replaceConsulta(Consulta entity, Integer id) {
		Optional<Consulta> optional = repository.findById(id);
		if(!optional.isPresent()) {
			return null;
		}	  
		entity.setId(id);
		return repository.save(entity);
	}

	void deleteConsulta(Integer id) {
		repository.deleteById(id);
	}

	public ConsultaRepository getRepository() {
		return repository;
	}

	public IAuthenticationFacade getAuthenticationFacade() {
		return authenticationFacade;
	}
	
}