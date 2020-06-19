package com.ebc43.bc_backend.TaskManagement.ModeloTarefa;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ModeloTarefaService {
	private final ModeloTarefaRepository repository;

	public ModeloTarefaService(ModeloTarefaRepository repository) {
		this.repository = repository;
	}

	List<ModeloTarefa> all() {
		return (List<ModeloTarefa>) repository.findAll();
	}

	ModeloTarefa newModeloTarefa(ModeloTarefa newModeloTarefa) {
		newModeloTarefa.setCreatedAt(new Date());
	    return repository.save(newModeloTarefa);
    }

	ModeloTarefa one(Integer id) {
		return repository.findById(id)
				.orElseThrow(() -> new ModeloTarefaNotFoundException(id));
	}

	ModeloTarefa replaceModeloTarefa(ModeloTarefa entity, Integer id) {
		Optional<ModeloTarefa> optional = repository.findById(id);
		if(!optional.isPresent()) {
			return null;
		}	  
		entity.setId(id);
		entity.setCreatedAt(optional.get().getCreatedAt());
		entity.setUpdatedAt(new Date());
		return repository.save(entity);
	}

	void deleteModeloTarefa(Integer id) {
		repository.deleteById(id);
	}
	
}