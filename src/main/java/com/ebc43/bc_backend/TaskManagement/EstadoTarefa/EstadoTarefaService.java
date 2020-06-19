package com.ebc43.bc_backend.TaskManagement.EstadoTarefa;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EstadoTarefaService {
	private final EstadoTarefaRepository repository;

	public EstadoTarefaService(EstadoTarefaRepository repository) {
		this.repository = repository;
	}

	List<EstadoTarefa> all() {
		return (List<EstadoTarefa>) repository.findAll();
	}

	EstadoTarefa newEstadoTarefa(EstadoTarefa newEstadoTarefa) {
		newEstadoTarefa.setCreatedAt(new Date());
	    return repository.save(newEstadoTarefa);
    }

	EstadoTarefa one(Integer id) {
		return repository.findById(id)
				.orElseThrow(() -> new EstadoTarefaNotFoundException(id));
	}

	EstadoTarefa replaceEstadoTarefa(EstadoTarefa entity, Integer id) {
		Optional<EstadoTarefa> optional = repository.findById(id);
		if(!optional.isPresent()) {
			return null;
		}	  
		entity.setId(id);
		entity.setCreatedAt(optional.get().getCreatedAt());
		entity.setUpdatedAt(new Date());
		return repository.save(entity);
	}

	void deleteEstadoTarefa(Integer id) {
		repository.deleteById(id);
	}
	
}