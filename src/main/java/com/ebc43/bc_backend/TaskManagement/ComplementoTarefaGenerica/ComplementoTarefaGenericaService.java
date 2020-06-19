package com.ebc43.bc_backend.TaskManagement.ComplementoTarefaGenerica;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class ComplementoTarefaGenericaService {
	private final ComplementoTarefaGenericaRepository repository;

	public ComplementoTarefaGenericaService(ComplementoTarefaGenericaRepository repository) {
		this.repository = repository;
	}

	List<ComplementoTarefaGenerica> all() {
		return (List<ComplementoTarefaGenerica>) repository.findAll();
	}

	ComplementoTarefaGenerica newComplementoTarefaGenerica(ComplementoTarefaGenerica newComplementoTarefaGenerica) {
		newComplementoTarefaGenerica.setCreatedAt(new Date());
	    return repository.save(newComplementoTarefaGenerica);
    }

	ComplementoTarefaGenerica one(UUID id) {
		return repository.findById(id)
				.orElseThrow(() -> new ComplementoTarefaGenericaNotFoundException(id));
	}

	ComplementoTarefaGenerica replaceComplementoTarefaGenerica(ComplementoTarefaGenerica entity, UUID id) {
		Optional<ComplementoTarefaGenerica> optional = repository.findById(id);
		if(!optional.isPresent()) {
			return null;
		}	  
		entity.setId(id);
		entity.setCreatedAt(optional.get().getCreatedAt());
		entity.setUpdatedAt(new Date());
		return repository.save(entity);
	}

	void deleteComplementoTarefaGenerica(UUID id) {
		repository.deleteById(id);
	}
}
