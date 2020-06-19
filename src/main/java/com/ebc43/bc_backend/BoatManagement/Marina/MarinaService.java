package com.ebc43.bc_backend.BoatManagement.Marina;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class MarinaService {
	private final MarinaRepository repository;

	public MarinaService(MarinaRepository repository) {
		this.repository = repository;
	}

	List<Marina> all() {
		return (List<Marina>) repository.findAll();
	}

	Marina newMarina(Marina newMarina) {
		newMarina.setCreatedAt(new Date());
	    return repository.save(newMarina);
    }

	Marina one(Integer id) {
		return repository.findById(id)
				.orElseThrow(() -> new MarinaNotFoundException(id));
	}

	Marina replaceMarina(Marina entity, Integer id) {
		Optional<Marina> optional = repository.findById(id);
		if(!optional.isPresent()) {
			return null;
		}	  
		entity.setId(id);
		entity.setCreatedAt(optional.get().getCreatedAt());
		entity.setUpdatedAt(new Date());
		return repository.save(entity);
	}

	void deleteMarina(Integer id) {
		repository.deleteById(id);
	}
	
}