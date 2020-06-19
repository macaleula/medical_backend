package com.ebc43.bc_backend.TaskManagement.PosRequisitoModeloTarefa;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ebc43.bc_backend.TaskManagement.PosRequisitoModeloTarefa.PosRequisitoModeloTarefa;
import com.ebc43.bc_backend.TaskManagement.PosRequisitoModeloTarefa.PosRequisitoModeloTarefaNotFoundException;
import com.ebc43.bc_backend.TaskManagement.PosRequisitoModeloTarefa.PosRequisitoModeloTarefaRepository;

@Service
public class PosRequisitoModeloTarefaService {
	private final PosRequisitoModeloTarefaRepository repository;

	public PosRequisitoModeloTarefaService(PosRequisitoModeloTarefaRepository repository) {
		this.repository = repository;
	}

	List<PosRequisitoModeloTarefa> all() {
		return (List<PosRequisitoModeloTarefa>) repository.findAll();
	}

	PosRequisitoModeloTarefa newPosRequisitoModeloTarefa(PosRequisitoModeloTarefa newPosRequisitoModeloTarefa) {
		newPosRequisitoModeloTarefa.setCreatedAt(new Date());
	    return repository.save(newPosRequisitoModeloTarefa);
    }

	PosRequisitoModeloTarefa one(Integer id) {
		return repository.findById(id)
				.orElseThrow(() -> new PosRequisitoModeloTarefaNotFoundException(id));
	}

	PosRequisitoModeloTarefa replacePosRequisitoModeloTarefa(PosRequisitoModeloTarefa entity, Integer id) {
		Optional<PosRequisitoModeloTarefa> optional = repository.findById(id);
		if(!optional.isPresent()) {
			return null;
		}	  
		entity.setId(id);
		entity.setCreatedAt(optional.get().getCreatedAt());
		entity.setUpdatedAt(new Date());
		return repository.save(entity);
	}

	void deletePosRequisitoModeloTarefa(Integer id) {
		repository.deleteById(id);
	}
	
}
