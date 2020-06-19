package com.ebc43.bc_backend.TaskManagement.UnidadeMedida;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class UnidadeMedidaService {
	private final UnidadeMedidaRepository repository;

	public UnidadeMedidaService(UnidadeMedidaRepository repository) {
		this.repository = repository;
	}

	List<UnidadeMedida> all() {
		return (List<UnidadeMedida>) repository.findAll();
	}

	UnidadeMedida newUnidadeMedida(UnidadeMedida newUnidadeMedida) {
		newUnidadeMedida.setCreatedAt(new Date());
	    return repository.save(newUnidadeMedida);
    }

	UnidadeMedida one(Integer id) {
		return repository.findById(id)
				.orElseThrow(() -> new UnidadeMedidaNotFoundException(id));
	}

	UnidadeMedida replaceUnidadeMedida(UnidadeMedida entity, Integer id) {
		Optional<UnidadeMedida> optional = repository.findById(id);
		if(!optional.isPresent()) {
			return null;
		}	  
		entity.setId(id);
		entity.setCreatedAt(optional.get().getCreatedAt());
		entity.setUpdatedAt(new Date());
		return repository.save(entity);
	}

	void deleteUnidadeMedida(Integer id) {
		repository.deleteById(id);
	}
	
}
