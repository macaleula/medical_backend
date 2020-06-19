package com.ebc43.bc_backend.RoutineSaylor.DiaSemana;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DiaSemanaService {
	private final DiaSemanaRepository repository;

	public DiaSemanaService(DiaSemanaRepository repository) {
		this.repository = repository;
	}

	List<DiaSemana> all() {
		return (List<DiaSemana>) repository.findAll();
	}

	DiaSemana newDiaSemana(DiaSemana newDiaSemana) {
		newDiaSemana.setCreatedAt(new Date());
	    return repository.save(newDiaSemana);
    }

	DiaSemana one(Integer id) {
		return repository.findById(id)
				.orElseThrow(() -> new DiaSemanaNotFoundException(id));
	}

	DiaSemana replaceDiaSemana(DiaSemana entity, Integer id) {
		Optional<DiaSemana> optional = repository.findById(id);
		if(!optional.isPresent()) {
			return null;
		}	  
		entity.setId(id);
		entity.setCreatedAt(optional.get().getCreatedAt());
		entity.setUpdatedAt(new Date());
		return repository.save(entity);
	}

	void deleteDiaSemana(Integer id) {
		repository.deleteById(id);
	}
	
}