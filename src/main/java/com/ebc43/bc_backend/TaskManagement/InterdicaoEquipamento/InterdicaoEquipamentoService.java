package com.ebc43.bc_backend.TaskManagement.InterdicaoEquipamento;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class InterdicaoEquipamentoService {
	private final InterdicaoEquipamentoRepository repository;

	public InterdicaoEquipamentoService(InterdicaoEquipamentoRepository repository) {
		this.repository = repository;
	}

	List<InterdicaoEquipamento> all() {
		return (List<InterdicaoEquipamento>) repository.findAll();
	}

	InterdicaoEquipamento newInterdicaoEquipamento(InterdicaoEquipamento newInterdicaoEquipamento) {
		newInterdicaoEquipamento.setCreatedAt(new Date());
	    return repository.save(newInterdicaoEquipamento);
    }

	InterdicaoEquipamento one(UUID id) {
		return repository.findById(id)
				.orElseThrow(() -> new InterdicaoEquipamentoNotFoundException(id));
	}

	InterdicaoEquipamento replaceInterdicaoEquipamento(InterdicaoEquipamento entity, UUID id) {
		Optional<InterdicaoEquipamento> optional = repository.findById(id);
		if(!optional.isPresent()) {
			return null;
		}	  
		entity.setId(id);
		entity.setCreatedAt(optional.get().getCreatedAt());
		entity.setUpdatedAt(new Date());
		return repository.save(entity);
	}

	void deleteInterdicaoEquipamento(UUID id) {
		repository.deleteById(id);
	}
	
}
