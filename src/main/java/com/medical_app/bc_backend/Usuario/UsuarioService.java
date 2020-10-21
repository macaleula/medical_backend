package com.medical_app.bc_backend.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {
	private final UsuarioRepository repository;
	
	public UsuarioService(UsuarioRepository repository) {
		this.repository = repository;
	}

	List<Usuario> all() {
		return (List<Usuario>) repository.findAll();
	}

	Usuario newUsuario(Usuario newUsuario) {
		System.out.println("informacoesSensiveis.username");
	    return null;//repository.save(newUsuario);
    }

	Usuario one(Integer id) {
		return repository.findById(id)
				.orElseThrow(() -> new UsuarioNotFoundException(id));
	}
	
	Usuario one(String username) {
		return repository.findByUserName(username)
				.orElseThrow(() -> new UsuarioNotFoundException(username));
	}

	Usuario replaceUsuario(Usuario entity, Integer id) {
		Optional<Usuario> optional = repository.findById(id);
		if(!optional.isPresent()) {
			return null;
		}	  
		entity.setId(id);
		return repository.save(entity);
	}

	void deleteUsuario(Integer id) {
		//Usuario u = repository.findById(id).get();

		repository.deleteById(id);
	}

}