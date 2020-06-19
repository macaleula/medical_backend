package com.ebc43.bc_backend.TaskManagement.RecursoHumanoModeloTarefa;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class RecursoHumanoModeloTarefaService {
	private final RecursoHumanoModeloTarefaRepository repository;

	public RecursoHumanoModeloTarefaService(RecursoHumanoModeloTarefaRepository repository) {
		this.repository = repository;
	}

	List<RecursoHumanoModeloTarefa> all() {
		return (List<RecursoHumanoModeloTarefa>) repository.findAll();
	}

	RecursoHumanoModeloTarefa newRecursoHumanoModeloTarefa(RecursoHumanoModeloTarefa newRecursoHumanoModeloTarefa) {
		newRecursoHumanoModeloTarefa.setCreatedAt(new Date());
	    return repository.save(newRecursoHumanoModeloTarefa);
    }

	RecursoHumanoModeloTarefa one(Integer id) {
		return repository.findById(id)
				.orElseThrow(() -> new RecursoHumanoModeloTarefaNotFoundException(id));
	}

	RecursoHumanoModeloTarefa replaceRecursoHumanoModeloTarefa(RecursoHumanoModeloTarefa entity, Integer id) {
		Optional<RecursoHumanoModeloTarefa> optional = repository.findById(id);
		if(!optional.isPresent()) {
			return null;
		}	  
		entity.setId(id);
		entity.setCreatedAt(optional.get().getCreatedAt());
		entity.setUpdatedAt(new Date());
		return repository.save(entity);
	}

	void deleteRecursoHumanoModeloTarefa(Integer id) {
		repository.deleteById(id);
	}
	
}
