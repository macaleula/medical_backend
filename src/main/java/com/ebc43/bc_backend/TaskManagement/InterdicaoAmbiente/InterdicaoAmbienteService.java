package com.ebc43.bc_backend.TaskManagement.InterdicaoAmbiente;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class InterdicaoAmbienteService {
	private final InterdicaoAmbienteRepository repository;

	public InterdicaoAmbienteService(InterdicaoAmbienteRepository repository) {
		this.repository = repository;
	}

	List<InterdicaoAmbiente> all() {
		return (List<InterdicaoAmbiente>) repository.findAll();
	}

	InterdicaoAmbiente newInterdicaoAmbiente(InterdicaoAmbiente newInterdicaoAmbiente) {
		newInterdicaoAmbiente.setCreatedAt(new Date());
	    return repository.save(newInterdicaoAmbiente);
    }

	InterdicaoAmbiente one(UUID id) {
		return repository.findById(id)
				.orElseThrow(() -> new InterdicaoAmbienteNotFoundException(id));
	}

	InterdicaoAmbiente replaceInterdicaoAmbiente(InterdicaoAmbiente entity, UUID id) {
		Optional<InterdicaoAmbiente> optional = repository.findById(id);
		if(!optional.isPresent()) {
			return null;
		}	  
		entity.setId(id);
		entity.setCreatedAt(optional.get().getCreatedAt());
		entity.setUpdatedAt(new Date());
		return repository.save(entity);
	}

	void deleteInterdicaoAmbiente(UUID id) {
		repository.deleteById(id);
	}
}
