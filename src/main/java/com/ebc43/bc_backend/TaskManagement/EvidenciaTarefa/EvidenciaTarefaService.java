package com.ebc43.bc_backend.TaskManagement.EvidenciaTarefa;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EvidenciaTarefaService {
	private final EvidenciaTarefaRepository repository;

	public EvidenciaTarefaService(EvidenciaTarefaRepository repository) {
		this.repository = repository;
	}

	List<EvidenciaTarefa> all() {
		return (List<EvidenciaTarefa>) repository.findAll();
	}

	EvidenciaTarefa newEvidenciaTarefa(EvidenciaTarefa newEvidenciaTarefa) {
		newEvidenciaTarefa.setCreatedAt(new Date());
	    return repository.save(newEvidenciaTarefa);
    }

	EvidenciaTarefa one(UUID id) {
		return repository.findById(id)
				.orElseThrow(() -> new EvidenciaTarefaNotFoundException(id));
	}

	EvidenciaTarefa replaceEvidenciaTarefa(EvidenciaTarefa entity, UUID id) {
		Optional<EvidenciaTarefa> optional = repository.findById(id);
		if(!optional.isPresent()) {
			return null;
		}	  
		entity.setId(id);
		entity.setCreatedAt(optional.get().getCreatedAt());
		entity.setUpdatedAt(new Date());
		return repository.save(entity);
	}

	void deleteEvidenciaTarefa(UUID id) {
		repository.deleteById(id);
	}

}