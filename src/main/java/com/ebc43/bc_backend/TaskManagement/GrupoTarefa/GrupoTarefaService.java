package com.ebc43.bc_backend.TaskManagement.GrupoTarefa;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class GrupoTarefaService {
	private final GrupoTarefaRepository repository;

	public GrupoTarefaService(GrupoTarefaRepository repository) {
		this.repository = repository;
	}

	List<GrupoTarefa> all() {
		return (List<GrupoTarefa>) repository.findAll();
	}

	GrupoTarefa newGrupoTarefa(GrupoTarefa newGrupoTarefa) {
		newGrupoTarefa.setCreatedAt(new Date());
	    return repository.save(newGrupoTarefa);
    }

	GrupoTarefa one(UUID id) {
		return repository.findById(id)
				.orElseThrow(() -> new GrupoTarefaNotFoundException(id));
	}

	GrupoTarefa replaceGrupoTarefa(GrupoTarefa entity, UUID id) {
		Optional<GrupoTarefa> optional = repository.findById(id);
		if(!optional.isPresent()) {
			return null;
		}	  
		entity.setId(id);
		entity.setCreatedAt(optional.get().getCreatedAt());
		entity.setUpdatedAt(new Date());
		return repository.save(entity);
	}

	void deleteGrupoTarefa(UUID id) {
		repository.deleteById(id);
	}
}
