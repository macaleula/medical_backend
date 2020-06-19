package com.ebc43.bc_backend.TaskManagement.EtapaTarefa;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EtapaTarefaService {
	private final EtapaTarefaRepository repository;

	public EtapaTarefaService(EtapaTarefaRepository repository) {
		this.repository = repository;
	}

	List<EtapaTarefa> all() {
		return (List<EtapaTarefa>) repository.findAll();
	}

	EtapaTarefa newEtapaTarefa(EtapaTarefa newEtapaTarefa) {
		newEtapaTarefa.setCreatedAt(new Date());
	    return repository.save(newEtapaTarefa);
    }

	EtapaTarefa one(UUID id) {
		return repository.findById(id)
				.orElseThrow(() -> new EtapaTarefaNotFoundException(id));
	}

	EtapaTarefa replaceEtapaTarefa(EtapaTarefa entity, UUID id) {
		Optional<EtapaTarefa> optional = repository.findById(id);
		if(!optional.isPresent()) {
			return null;
		}	  
		entity.setId(id);
		entity.setCreatedAt(optional.get().getCreatedAt());
		entity.setUpdatedAt(new Date());
		return repository.save(entity);
	}

	void deleteEtapaTarefa(UUID id) {
		repository.deleteById(id);
	}
}