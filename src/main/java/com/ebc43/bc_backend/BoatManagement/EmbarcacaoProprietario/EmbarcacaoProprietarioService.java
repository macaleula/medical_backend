package com.ebc43.bc_backend.BoatManagement.EmbarcacaoProprietario;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class EmbarcacaoProprietarioService {
	private final EmbarcacaoProprietarioRepository repository;

	public EmbarcacaoProprietarioService(EmbarcacaoProprietarioRepository repository) {
		this.repository = repository;
	}

	List<EmbarcacaoProprietario> all() {
		return (List<EmbarcacaoProprietario>) repository.findAll();
	}

	EmbarcacaoProprietario newEmbarcacaoProprietario(EmbarcacaoProprietario newEmbarcacaoProprietario) {
		newEmbarcacaoProprietario.setCreatedAt(new Date());
	    return repository.save(newEmbarcacaoProprietario);
    }

	EmbarcacaoProprietario one(Integer id) {
		return repository.findById(id)
				.orElseThrow(() -> new EmbarcacaoProprietarioNotFoundException(id));
	}

	EmbarcacaoProprietario replaceEmbarcacaoProprietario(EmbarcacaoProprietario entity, Integer id) {
		Optional<EmbarcacaoProprietario> optional = repository.findById(id);
		if(!optional.isPresent()) {
			return null;
		}	  
		entity.setId(id);
		entity.setCreatedAt(optional.get().getCreatedAt());
		entity.setUpdatedAt(new Date());
		return repository.save(entity);
	}

	void deleteEmbarcacaoProprietario(Integer id) {
		repository.deleteById(id);
	}
	
}
