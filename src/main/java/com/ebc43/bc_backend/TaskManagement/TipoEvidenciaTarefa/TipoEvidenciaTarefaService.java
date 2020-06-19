package com.ebc43.bc_backend.TaskManagement.TipoEvidenciaTarefa;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class TipoEvidenciaTarefaService {
	private final TipoEvidenciaTarefaRepository repository;

	public TipoEvidenciaTarefaService(TipoEvidenciaTarefaRepository repository) {
		this.repository = repository;
	}

	List<TipoEvidenciaTarefa> all() {
		return (List<TipoEvidenciaTarefa>) repository.findAll();
	}

	TipoEvidenciaTarefa newTipoEvidenciaTarefa(TipoEvidenciaTarefa newTipoEvidenciaTarefa) {
		newTipoEvidenciaTarefa.setCreatedAt(new Date());
	    return repository.save(newTipoEvidenciaTarefa);
    }

	TipoEvidenciaTarefa one(Integer id) {
		return repository.findById(id)
				.orElseThrow(() -> new TipoEvidenciaTarefaNotFoundException(id));
	}

	TipoEvidenciaTarefa replaceTipoEvidenciaTarefa(TipoEvidenciaTarefa entity, Integer id) {
		Optional<TipoEvidenciaTarefa> optional = repository.findById(id);
		if(!optional.isPresent()) {
			return null;
		}	  
		entity.setId(id);
		entity.setCreatedAt(optional.get().getCreatedAt());
		entity.setUpdatedAt(new Date());
		return repository.save(entity);
	}

	void deleteTipoEvidenciaTarefa(Integer id) {
		repository.deleteById(id);
	}
	
}
