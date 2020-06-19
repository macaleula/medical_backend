package com.ebc43.bc_backend.TaskManagement.ModeloAtributoEquipamento;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ebc43.bc_backend.TaskManagement.ModeloAtributoEquipamento.ModeloAtributoEquipamento;
import com.ebc43.bc_backend.TaskManagement.ModeloAtributoEquipamento.ModeloAtributoEquipamentoNotFoundException;
import com.ebc43.bc_backend.TaskManagement.ModeloAtributoEquipamento.ModeloAtributoEquipamentoRepository;

@Service
public class ModeloAtributoEquipamentoService {
	private final ModeloAtributoEquipamentoRepository repository;

	public ModeloAtributoEquipamentoService(ModeloAtributoEquipamentoRepository repository) {
		this.repository = repository;
	}

	List<ModeloAtributoEquipamento> all() {
		return (List<ModeloAtributoEquipamento>) repository.findAll();
	}

	ModeloAtributoEquipamento newModeloAtributoEquipamento(ModeloAtributoEquipamento newModeloAtributoEquipamento) {
		newModeloAtributoEquipamento.setCreatedAt(new Date());
	    return repository.save(newModeloAtributoEquipamento);
    }

	ModeloAtributoEquipamento one(Integer id) {
		return repository.findById(id)
				.orElseThrow(() -> new ModeloAtributoEquipamentoNotFoundException(id));
	}

	ModeloAtributoEquipamento replaceModeloAtributoEquipamento(ModeloAtributoEquipamento entity, Integer id) {
		Optional<ModeloAtributoEquipamento> optional = repository.findById(id);
		if(!optional.isPresent()) {
			return null;
		}	  
		entity.setId(id);
		entity.setCreatedAt(optional.get().getCreatedAt());
		entity.setUpdatedAt(new Date());
		return repository.save(entity);
	}

	void deleteModeloAtributoEquipamento(Integer id) {
		repository.deleteById(id);
	}
	
}
