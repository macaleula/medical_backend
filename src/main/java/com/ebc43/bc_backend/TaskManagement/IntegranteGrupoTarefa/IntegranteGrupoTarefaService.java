package com.ebc43.bc_backend.TaskManagement.IntegranteGrupoTarefa;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class IntegranteGrupoTarefaService {
	private final IntegranteGrupoTarefaRepository repository;

	public IntegranteGrupoTarefaService(IntegranteGrupoTarefaRepository repository) {
		this.repository = repository;
	}

	List<IntegranteGrupoTarefa> all() {
		return (List<IntegranteGrupoTarefa>) repository.findAll();
	}

	IntegranteGrupoTarefa newIntegranteGrupoTarefa(IntegranteGrupoTarefa newIntegranteGrupoTarefa) {
		newIntegranteGrupoTarefa.setCreatedAt(new Date());
	    return repository.save(newIntegranteGrupoTarefa);
    }

	IntegranteGrupoTarefa one(UUID id) {
		return repository.findById(id)
				.orElseThrow(() -> new IntegranteGrupoTarefaNotFoundException(id));
	}

	IntegranteGrupoTarefa replaceIntegranteGrupoTarefa(IntegranteGrupoTarefa entity, UUID id) {
		Optional<IntegranteGrupoTarefa> optional = repository.findById(id);
		if(!optional.isPresent()) {
			return null;
		}	  
		entity.setId(id);
		entity.setCreatedAt(optional.get().getCreatedAt());
		entity.setUpdatedAt(new Date());
		return repository.save(entity);
	}

	void deleteIntegranteGrupoTarefa(UUID id) {
		repository.deleteById(id);
	}
}
