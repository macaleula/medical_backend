package com.ebc43.bc_backend.TaskManagement.MarinheiroEscalado;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class MarinheiroEscaladoService {
	private final MarinheiroEscaladoRepository repository;

	public MarinheiroEscaladoService(MarinheiroEscaladoRepository repository) {
		this.repository = repository;
	}

	List<MarinheiroEscalado> all() {
		return (List<MarinheiroEscalado>) repository.findAll();
	}

	MarinheiroEscalado newMarinheiroEscalado(MarinheiroEscalado newMarinheiroEscalado) {
		newMarinheiroEscalado.setCreatedAt(new Date());
	    return repository.save(newMarinheiroEscalado);
    }

	MarinheiroEscalado one(UUID id) {
		return repository.findById(id)
				.orElseThrow(() -> new MarinheiroEscaladoNotFoundException(id));
	}

	MarinheiroEscalado replaceMarinheiroEscalado(MarinheiroEscalado entity, UUID id) {
		Optional<MarinheiroEscalado> optional = repository.findById(id);
		if(!optional.isPresent()) {
			return null;
		}	  
		entity.setId(id);
		entity.setCreatedAt(optional.get().getCreatedAt());
		entity.setUpdatedAt(new Date());
		return repository.save(entity);
	}

	void deleteMarinheiroEscalado(UUID id) {
		repository.deleteById(id);
	}
	
}
