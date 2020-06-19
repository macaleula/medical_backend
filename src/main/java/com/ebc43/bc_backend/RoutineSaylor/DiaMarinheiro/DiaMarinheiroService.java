package com.ebc43.bc_backend.RoutineSaylor.DiaMarinheiro;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DiaMarinheiroService {
	private final DiaMarinheiroRepository repository;

	public DiaMarinheiroService(DiaMarinheiroRepository repository) {
		this.repository = repository;
	}

	List<DiaMarinheiro> all() {
		return (List<DiaMarinheiro>) repository.findAll();
	}

	DiaMarinheiro newDiaMarinheiro(DiaMarinheiro newDiaMarinheiro) {
		newDiaMarinheiro.setCreatedAt(new Date());
	    return repository.save(newDiaMarinheiro);
    }

	DiaMarinheiro one(UUID id) {
		return repository.findById(id)
				.orElseThrow(() -> new DiaMarinheiroNotFoundException(id));
	}

	DiaMarinheiro replaceDiaMarinheiro(DiaMarinheiro entity, UUID id) {
		Optional<DiaMarinheiro> optional = repository.findById(id);
		if(!optional.isPresent()) {
			return null;
		}	  
		entity.setId(id);
		entity.setCreatedAt(optional.get().getCreatedAt());
		entity.setUpdatedAt(new Date());
		return repository.save(entity);
	}

	void deleteDiaMarinheiro(UUID id) {
		repository.deleteById(id);
	}

}