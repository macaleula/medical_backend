package com.medical_app.bc_backend.TipoUsuario;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TipoUsuarioService {
	private final TipoUsuarioRepository repository;

	public TipoUsuarioService(TipoUsuarioRepository repository) {
		this.repository = repository;
	}

	List<TipoUsuario> all() {
		return (List<TipoUsuario>) repository.findAll();
	}

	TipoUsuario newTipoUsuario(TipoUsuario newEntity) {
	    return repository.save(newEntity);
    }

	TipoUsuario one(Integer id) {
		return repository.findById(id)
				.orElseThrow(() -> new TipoUsuarioNotFoundException(id));
	}

	TipoUsuario replaceTipoUsuario(TipoUsuario entity, Integer id) {
		Optional<TipoUsuario> optional = repository.findById(id);
		if(!optional.isPresent()) {
			return null;
		}	  
		entity.setId(id);
		return repository.save(entity);
	}

	void deleteTipoUsuario(Integer id) {
		repository.deleteById(id);
	}
	
}