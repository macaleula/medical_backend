package com.ebc43.bc_backend.TaskManagement.ModeloEvidenciaTarefa;

import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ModeloEvidenciaTarefaService {
	private final ModeloEvidenciaTarefaRepository repository;

	public ModeloEvidenciaTarefaService(ModeloEvidenciaTarefaRepository repository) {
		this.repository = repository;
	}

	List<ModeloEvidenciaTarefa> all() {
		return (List<ModeloEvidenciaTarefa>) repository.findAll();
	}

	ModeloEvidenciaTarefa newModeloEvidenciaTarefa(ModeloEvidenciaTarefa newModeloEvidenciaTarefa) {
		newModeloEvidenciaTarefa.setCreatedAt(new Date());
	    return repository.save(newModeloEvidenciaTarefa);
    }

	ModeloEvidenciaTarefa one(Integer id) {
		return repository.findById(id)
				.orElseThrow(() -> new ModeloEvidenciaTarefaNotFoundException(id));
	}

	ModeloEvidenciaTarefa replaceModeloEvidenciaTarefa(ModeloEvidenciaTarefa entity, Integer id) {
		Optional<ModeloEvidenciaTarefa> optional = repository.findById(id);
		if(!optional.isPresent()) {
			return null;
		}	  
		entity.setId(id);
		entity.setCreatedAt(optional.get().getCreatedAt());
		entity.setUpdatedAt(new Date());
		return repository.save(entity);
	}

	void deleteModeloEvidenciaTarefa(Integer id) {
		repository.deleteById(id);
	}
	
}