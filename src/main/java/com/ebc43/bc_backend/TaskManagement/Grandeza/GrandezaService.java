package com.ebc43.bc_backend.TaskManagement.Grandeza;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class GrandezaService {
	private final GrandezaRepository repository;

	public GrandezaService(GrandezaRepository repository) {
		this.repository = repository;
	}

	List<Grandeza> all() {
		return (List<Grandeza>) repository.findAll();
	}

	Grandeza newGrandeza(Grandeza newGrandeza) {
		newGrandeza.setCreatedAt(new Date());
	    return repository.save(newGrandeza);
    }

	Grandeza one(Integer id) {
		return repository.findById(id)
				.orElseThrow(() -> new GrandezaNotFoundException(id));
	}

	Grandeza replaceGrandeza(Grandeza entity, Integer id) {
		Optional<Grandeza> optional = repository.findById(id);
		if(!optional.isPresent()) {
			return null;
		}	  
		entity.setId(id);
		entity.setCreatedAt(optional.get().getCreatedAt());
		entity.setUpdatedAt(new Date());
		return repository.save(entity);
	}

	void deleteGrandeza(Integer id) {
		repository.deleteById(id);
	}
	
}
