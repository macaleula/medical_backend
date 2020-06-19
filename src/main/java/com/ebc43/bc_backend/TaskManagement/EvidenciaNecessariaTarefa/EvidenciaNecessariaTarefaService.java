package com.ebc43.bc_backend.TaskManagement.EvidenciaNecessariaTarefa;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class EvidenciaNecessariaTarefaService {
	private final EvidenciaNecessariaTarefaRepository repository;

	public EvidenciaNecessariaTarefaService(EvidenciaNecessariaTarefaRepository repository) {
		this.repository = repository;
	}

	List<EvidenciaNecessariaTarefa> all() {
		return (List<EvidenciaNecessariaTarefa>) repository.findAll();
	}

	EvidenciaNecessariaTarefa newEvidenciaNecessariaTarefa(EvidenciaNecessariaTarefa newEvidenciaNecessariaTarefa) {
		newEvidenciaNecessariaTarefa.setCreatedAt(new Date());
	    return repository.save(newEvidenciaNecessariaTarefa);
    }

	EvidenciaNecessariaTarefa one(Integer id) {
		return repository.findById(id)
				.orElseThrow(() -> new EvidenciaNecessariaTarefaNotFoundException(id));
	}

	EvidenciaNecessariaTarefa replaceEvidenciaNecessariaTarefa(EvidenciaNecessariaTarefa entity, Integer id) {
		Optional<EvidenciaNecessariaTarefa> optional = repository.findById(id);
		if(!optional.isPresent()) {
			return null;
		}	  
		entity.setId(id);
		entity.setCreatedAt(optional.get().getCreatedAt());
		entity.setUpdatedAt(new Date());
		return repository.save(entity);
	}

	void deleteEvidenciaNecessariaTarefa(Integer id) {
		repository.deleteById(id);
	}
	
}
