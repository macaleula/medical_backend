package com.ebc43.bc_backend.BoatManagement.ModeloEmbarcacao;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ModeloEmbarcacaoService {
	private final ModeloEmbarcacaoRepository repository;

	public ModeloEmbarcacaoService(ModeloEmbarcacaoRepository repository) {
		this.repository = repository;
	}

	List<ModeloEmbarcacao> all() {
		return (List<ModeloEmbarcacao>) repository.findAll();
	}

	ModeloEmbarcacao newModeloEmbarcacao(ModeloEmbarcacao newModeloEmbarcacao) {
		newModeloEmbarcacao.setCreatedAt(new Date());
	    return repository.save(newModeloEmbarcacao);
    }

	ModeloEmbarcacao one(Integer id) {
		return repository.findById(id)
				.orElseThrow(() -> new ModeloEmbarcacaoNotFoundException(id));
	}

	ModeloEmbarcacao replaceModeloEmbarcacao(ModeloEmbarcacao entity, Integer id) {
		Optional<ModeloEmbarcacao> optional = repository.findById(id);
		if(!optional.isPresent()) {
			return null;
		}	  
		entity.setId(id);
		entity.setCreatedAt(optional.get().getCreatedAt());
		entity.setUpdatedAt(new Date());
		return repository.save(entity);
	}

	void deleteModeloEmbarcacao(Integer id) {
		repository.deleteById(id);
	}

}