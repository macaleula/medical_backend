package com.ebc43.bc_backend.TaskManagement.PropriedadeModeloEquipamento;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class PropriedadeModeloEquipamentoService {
	private final PropriedadeModeloEquipamentoRepository repository;

	public PropriedadeModeloEquipamentoService(PropriedadeModeloEquipamentoRepository repository) {
		this.repository = repository;
	}

	List<PropriedadeModeloEquipamento> all() {
		return (List<PropriedadeModeloEquipamento>) repository.findAll();
	}

	PropriedadeModeloEquipamento newPropriedadeModeloEquipamento(PropriedadeModeloEquipamento newPropriedadeModeloEquipamento) {
		newPropriedadeModeloEquipamento.setCreatedAt(new Date());
	    return repository.save(newPropriedadeModeloEquipamento);
    }

	PropriedadeModeloEquipamento one(Integer id) {
		return repository.findById(id)
				.orElseThrow(() -> new PropriedadeModeloEquipamentoNotFoundException(id));
	}

	PropriedadeModeloEquipamento replacePropriedadeModeloEquipamento(PropriedadeModeloEquipamento entity, Integer id) {
		Optional<PropriedadeModeloEquipamento> optional = repository.findById(id);
		if(!optional.isPresent()) {
			return null;
		}	  
		entity.setId(id);
		entity.setCreatedAt(optional.get().getCreatedAt());
		entity.setUpdatedAt(new Date());
		return repository.save(entity);
	}

	void deletePropriedadeModeloEquipamento(Integer id) {
		repository.deleteById(id);
	}
	
}
