package com.ebc43.bc_backend.RoutineSaylor.EscalaDiaTrabalho;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class EscalaDiaTrabalhoService {
	private final EscalaDiaTrabalhoRepository repository;

	public EscalaDiaTrabalhoService(EscalaDiaTrabalhoRepository repository) {
		this.repository = repository;
	}

	List<EscalaDiaTrabalho> all() {
		return (List<EscalaDiaTrabalho>) repository.findAll();
	}

	EscalaDiaTrabalho newEscalaDiaTrabalho(EscalaDiaTrabalho newEscalaDiaTrabalho) {
		newEscalaDiaTrabalho.setCreatedAt(new Date());
	    return repository.save(newEscalaDiaTrabalho);
    }

	EscalaDiaTrabalho one(UUID id) {
		return repository.findById(id)
				.orElseThrow(() -> new EscalaDiaTrabalhoNotFoundException(id));
	}

	EscalaDiaTrabalho replaceEscalaDiaTrabalho(EscalaDiaTrabalho entity, UUID id) {
		Optional<EscalaDiaTrabalho> optional = repository.findById(id);
		if(!optional.isPresent()) {
			return null;
		}	  
		entity.setId(id);
		entity.setCreatedAt(optional.get().getCreatedAt());
		entity.setUpdatedAt(new Date());
		return repository.save(entity);
	}

	void deleteEscalaDiaTrabalho(UUID id) {
		repository.deleteById(id);
	}

}
