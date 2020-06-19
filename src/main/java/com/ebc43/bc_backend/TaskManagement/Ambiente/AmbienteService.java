package com.ebc43.bc_backend.TaskManagement.Ambiente;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AmbienteService {
	private final AmbienteRepository repository;

	public AmbienteService(AmbienteRepository repository) {
		this.repository = repository;
	}

	List<Ambiente> all() {
		return (List<Ambiente>) repository.findAll();
	}

	Ambiente newAmbiente(Ambiente newAmbiente) {
		newAmbiente.setCreatedAt(new Date());
	    return repository.save(newAmbiente);
    }

	Ambiente one(Integer id) {
		return repository.findById(id)
				.orElseThrow(() -> new AmbienteNotFoundException(id));
	}

	Ambiente replaceAmbiente(Ambiente entity, Integer id) {
		Optional<Ambiente> optional = repository.findById(id);
		if(!optional.isPresent()) {
			return null;
		}	  
		entity.setId(id);
		entity.setCreatedAt(optional.get().getCreatedAt());
		entity.setUpdatedAt(new Date());
		return repository.save(entity);
	}

	void deleteAmbiente(Integer id) {
		repository.deleteById(id);
	}
	
}