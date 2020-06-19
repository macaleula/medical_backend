package com.ebc43.bc_backend.BoatManagement.Embarcacao;

import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class EmbarcacaoService {
	private final EmbarcacaoRepository repository;

	public EmbarcacaoService(EmbarcacaoRepository repository) {
		this.repository = repository;
	}

	List<Embarcacao> all() {
		return (List<Embarcacao>) repository.findAll();
	}

	Embarcacao newEmbarcacao(Embarcacao newEmbarcacao) {
		newEmbarcacao.setCreatedAt(new Date());
	    return repository.save(newEmbarcacao);
    }

	Embarcacao one(Integer id) {
		return repository.findById(id)
				.orElseThrow(() -> new EmbarcacaoNotFoundException(id));
	}
	  
	Embarcacao byNome(String nome) {
		return repository.findByNome(nome);
	}
	  
	Embarcacao byMarina(String nome) {
		return repository.findByMarina(nome);
	}

	Embarcacao replaceEmbarcacao(Embarcacao entity, Integer id) {
		Optional<Embarcacao> optional = repository.findById(id);
		if(!optional.isPresent()) {
			return null;
		}	  
		entity.setId(id);
		entity.setCreatedAt(optional.get().getCreatedAt());
		entity.setUpdatedAt(new Date());
		return repository.save(entity);
	}

	void deleteEmbarcacao(Integer id) {
		repository.deleteById(id);
	}
	
}