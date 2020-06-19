package com.ebc43.bc_backend.TaskManagement.PreRequisitoModeloTarefa;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class PreRequisitoModeloTarefaService {
	private final PreRequisitoModeloTarefaRepository repository;

	public PreRequisitoModeloTarefaService(PreRequisitoModeloTarefaRepository repository) {
		this.repository = repository;
	}

	List<PreRequisitoModeloTarefa> all() {
		return (List<PreRequisitoModeloTarefa>) repository.findAll();
	}

	PreRequisitoModeloTarefa newPreRequisitoModeloTarefa(PreRequisitoModeloTarefa newPreRequisitoModeloTarefa) {
		newPreRequisitoModeloTarefa.setCreatedAt(new Date());
	    return repository.save(newPreRequisitoModeloTarefa);
    }

	PreRequisitoModeloTarefa one(Integer id) {
		return repository.findById(id)
				.orElseThrow(() -> new PreRequisitoModeloTarefaNotFoundException(id));
	}

	PreRequisitoModeloTarefa replacePreRequisitoModeloTarefa(PreRequisitoModeloTarefa entity, Integer id) {
		Optional<PreRequisitoModeloTarefa> optional = repository.findById(id);
		if(!optional.isPresent()) {
			return null;
		}	  
		entity.setId(id);
		entity.setCreatedAt(optional.get().getCreatedAt());
		entity.setUpdatedAt(new Date());
		return repository.save(entity);
	}

	void deletePreRequisitoModeloTarefa(Integer id) {
		repository.deleteById(id);
	}
	
}
