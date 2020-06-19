package com.ebc43.bc_backend.TaskManagement.ModeloAmbiente;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ModeloAmbienteService {
	private final ModeloAmbienteRepository repository;

	public ModeloAmbienteService(ModeloAmbienteRepository repository) {
		this.repository = repository;
	}

	List<ModeloAmbiente> all() {
		return (List<ModeloAmbiente>) repository.findAll();
	}

	ModeloAmbiente newModeloAmbiente(ModeloAmbiente newModeloAmbiente) {
		newModeloAmbiente.setCreatedAt(new Date());
	    return repository.save(newModeloAmbiente);
    }

	ModeloAmbiente one(Integer id) {
		return repository.findById(id)
				.orElseThrow(() -> new ModeloAmbienteNotFoundException(id));
	}

	ModeloAmbiente replaceModeloAmbiente(ModeloAmbiente entity, Integer id) {
		Optional<ModeloAmbiente> optional = repository.findById(id);
		if(optional.isPresent()) {
			return null;
		}	  
		entity.setId(id);
		entity.setCreatedAt(optional.get().getCreatedAt());
		entity.setUpdatedAt(new Date());
		return repository.save(entity);
	}

	void deleteModeloAmbiente(Integer id) {
		repository.deleteById(id);
	}
	
}