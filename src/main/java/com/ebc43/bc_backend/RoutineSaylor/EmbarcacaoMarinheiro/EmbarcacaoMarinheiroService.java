package com.ebc43.bc_backend.RoutineSaylor.EmbarcacaoMarinheiro;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EmbarcacaoMarinheiroService {
	private final EmbarcacaoMarinheiroRepository repository;

	public EmbarcacaoMarinheiroService(EmbarcacaoMarinheiroRepository repository) {
		this.repository = repository;
	}

	List<EmbarcacaoMarinheiro> all() {
		return (List<EmbarcacaoMarinheiro>) repository.findAll();
	}

	EmbarcacaoMarinheiro newEmbarcacaoMarinheiro(EmbarcacaoMarinheiro newEmbarcacaoMarinheiro) {
		newEmbarcacaoMarinheiro.setCreatedAt(new Date());
	    return repository.save(newEmbarcacaoMarinheiro);
    }

	EmbarcacaoMarinheiro one(Integer id) {
		return repository.findById(id)
				.orElseThrow(() -> new EmbarcacaoMarinheiroNotFoundException(id));
	}

	EmbarcacaoMarinheiro replaceEmbarcacaoMarinheiro(EmbarcacaoMarinheiro entity, Integer id) {
		Optional<EmbarcacaoMarinheiro> optional = repository.findById(id);
		if(!optional.isPresent()) {
			return null;
		}	  
		entity.setId(id);
		entity.setCreatedAt(optional.get().getCreatedAt());
		entity.setUpdatedAt(new Date());
		return repository.save(entity);
	}

	void deleteEmbarcacaoMarinheiro(Integer id) {
		repository.deleteById(id);
	}

}
