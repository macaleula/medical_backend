package com.ebc43.bc_backend.TaskManagement.AtributoEquipamento;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class AtributoEquipamentoService {
	private final AtributoEquipamentoRepository repository;

	public AtributoEquipamentoService(AtributoEquipamentoRepository repository) {
		this.repository = repository;
	}

	List<AtributoEquipamento> all() {
		return (List<AtributoEquipamento>) repository.findAll();
	}

	AtributoEquipamento newAtributoEquipamento(AtributoEquipamento newAtributoEquipamento) {
		newAtributoEquipamento.setCreatedAt(new Date());
	    return repository.save(newAtributoEquipamento);
    }

	AtributoEquipamento one(UUID id) {
		return repository.findById(id)
				.orElseThrow(() -> new AtributoEquipamentoNotFoundException(id));
	}

	AtributoEquipamento replaceAtributoEquipamento(AtributoEquipamento entity, UUID id) {
		Optional<AtributoEquipamento> optional = repository.findById(id);
		if(!optional.isPresent()) {
			return null;
		}	  
		entity.setId(id);
		entity.setCreatedAt(optional.get().getCreatedAt());
		entity.setUpdatedAt(new Date());
		return repository.save(entity);
	}

	void deleteAtributoEquipamento(UUID id) {
		repository.deleteById(id);
	}
}
