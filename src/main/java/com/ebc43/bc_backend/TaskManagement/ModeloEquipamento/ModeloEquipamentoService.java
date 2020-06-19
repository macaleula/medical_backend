package com.ebc43.bc_backend.TaskManagement.ModeloEquipamento;

import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ModeloEquipamentoService {
	private final ModeloEquipamentoRepository repository;

	public ModeloEquipamentoService(ModeloEquipamentoRepository repository) {
		this.repository = repository;
	}

	List<ModeloEquipamento> all() {
		return (List<ModeloEquipamento>) repository.findAll();
	}

	ModeloEquipamento newModeloEquipamento(ModeloEquipamento newModeloEquipamento) {
		newModeloEquipamento.setCreatedAt(new Date());
	    return repository.save(newModeloEquipamento);
    }

	ModeloEquipamento one(Integer id) {
		return repository.findById(id)
				.orElseThrow(() -> new ModeloEquipamentoNotFoundException(id));
	}

	ModeloEquipamento replaceModeloEquipamento(ModeloEquipamento entity, Integer id) {
		Optional<ModeloEquipamento> optional = repository.findById(id);
		if(!optional.isPresent()) {
			return null;
		}	  
		entity.setId(id);
		entity.setCreatedAt(optional.get().getCreatedAt());
		entity.setUpdatedAt(new Date());
		return repository.save(entity);
	}

	void deleteModeloEquipamento(Integer id) {
		repository.deleteById(id);
	}
	

}