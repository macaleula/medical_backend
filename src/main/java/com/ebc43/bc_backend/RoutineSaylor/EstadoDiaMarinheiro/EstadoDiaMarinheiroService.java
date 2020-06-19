package com.ebc43.bc_backend.RoutineSaylor.EstadoDiaMarinheiro;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EstadoDiaMarinheiroService {
	private final EstadoDiaMarinheiroRepository repository;

	public EstadoDiaMarinheiroService(EstadoDiaMarinheiroRepository repository) {
		this.repository = repository;
	}

	List<EstadoDiaMarinheiro> all() {
		return (List<EstadoDiaMarinheiro>) repository.findAll();
	}

	EstadoDiaMarinheiro newEstadoDiaMarinheiro(EstadoDiaMarinheiro newEstadoDiaMarinheiro) {
		newEstadoDiaMarinheiro.setCreatedAt(new Date());
	    return repository.save(newEstadoDiaMarinheiro);
    }

	EstadoDiaMarinheiro one(Integer id) {
		return repository.findById(id)
				.orElseThrow(() -> new EstadoDiaMarinheiroNotFoundException(id));
	}

	EstadoDiaMarinheiro replaceEstadoDiaMarinheiro(EstadoDiaMarinheiro entity, Integer id) {
		Optional<EstadoDiaMarinheiro> optional = repository.findById(id);
		if(!optional.isPresent()) {
			return null;
		}	  
		entity.setId(id);
		entity.setCreatedAt(optional.get().getCreatedAt());
		entity.setUpdatedAt(new Date());
		return repository.save(entity);
	}

	void deleteEstadoDiaMarinheiro(Integer id) {
		repository.deleteById(id);
	}
	
}
