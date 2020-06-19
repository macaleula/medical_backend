package com.ebc43.bc_backend.TaskManagement.UsuarioEtapaTarefaVista;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.ebc43.bc_backend.TaskManagement.UsuarioEtapaTarefaVista.UsuarioEtapaTarefaVista;
import com.ebc43.bc_backend.TaskManagement.UsuarioEtapaTarefaVista.UsuarioEtapaTarefaVistaNotFoundException;
import com.ebc43.bc_backend.TaskManagement.UsuarioEtapaTarefaVista.UsuarioEtapaTarefaVistaRepository;

@Service
public class UsuarioEtapaTarefaVistaService {
	private final UsuarioEtapaTarefaVistaRepository repository;

	public UsuarioEtapaTarefaVistaService(UsuarioEtapaTarefaVistaRepository repository) {
		this.repository = repository;
	}

	List<UsuarioEtapaTarefaVista> all() {
		return (List<UsuarioEtapaTarefaVista>) repository.findAll();
	}

	UsuarioEtapaTarefaVista newUsuarioEtapaTarefaVista(UsuarioEtapaTarefaVista newUsuarioEtapaTarefaVista) {
		newUsuarioEtapaTarefaVista.setCreatedAt(new Date());
	    return repository.save(newUsuarioEtapaTarefaVista);
    }

	UsuarioEtapaTarefaVista one(UUID id) {
		return repository.findById(id)
				.orElseThrow(() -> new UsuarioEtapaTarefaVistaNotFoundException(id));
	}

	UsuarioEtapaTarefaVista replaceUsuarioEtapaTarefaVista(UsuarioEtapaTarefaVista entity, UUID id) {
		Optional<UsuarioEtapaTarefaVista> optional = repository.findById(id);
		if(!optional.isPresent()) {
			return null;
		}	  
		entity.setId(id);
		entity.setCreatedAt(optional.get().getCreatedAt());
		entity.setUpdatedAt(new Date());
		return repository.save(entity);
	}

	void deleteUsuarioEtapaTarefaVista(UUID id) {
		repository.deleteById(id);
	}
	
}
