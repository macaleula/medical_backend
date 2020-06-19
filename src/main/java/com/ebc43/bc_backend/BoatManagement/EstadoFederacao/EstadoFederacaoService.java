package com.ebc43.bc_backend.BoatManagement.EstadoFederacao;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EstadoFederacaoService {
	private final EstadoFederacaoRepository repository;

	public EstadoFederacaoService(EstadoFederacaoRepository repository) {
		this.repository = repository;
	}

	List<EstadoFederacao> all() {
		return (List<EstadoFederacao>) repository.findAll();
	}

	EstadoFederacao newEstadoFederacao(EstadoFederacao newEstadoFederacao) {
		newEstadoFederacao.setCreatedAt(new Date());
	    return repository.save(newEstadoFederacao);
    }

	EstadoFederacao one(Integer id) {
		return repository.findById(id)
				.orElseThrow(() -> new EstadoFederacaoNotFoundException(id));
	}

	EstadoFederacao replaceEstadoFederacao(EstadoFederacao entity, Integer id) {
		Optional<EstadoFederacao> optional = repository.findById(id);
		if(!optional.isPresent()) {
			return null;
		}	  
		entity.setId(id);
		entity.setCreatedAt(optional.get().getCreatedAt());
		entity.setUpdatedAt(new Date());
		return repository.save(entity);
	}

	void deleteEstadoFederacao(Integer id) {
		repository.deleteById(id);
	}
	
}
