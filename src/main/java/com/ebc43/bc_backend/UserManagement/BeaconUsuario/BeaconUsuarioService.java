package com.ebc43.bc_backend.UserManagement.BeaconUsuario;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ebc43.bc_backend.UserManagement.BeaconUsuario.BeaconUsuario;
import com.ebc43.bc_backend.UserManagement.BeaconUsuario.BeaconUsuarioNotFoundException;
import com.ebc43.bc_backend.UserManagement.BeaconUsuario.BeaconUsuarioRepository;

@Service
public class BeaconUsuarioService {
	private final BeaconUsuarioRepository repository;

	public BeaconUsuarioService(BeaconUsuarioRepository repository) {
		this.repository = repository;
	}

	List<BeaconUsuario> all() {
		return (List<BeaconUsuario>) repository.findAll();
	}

	BeaconUsuario newBeaconUsuario(BeaconUsuario newBeaconUsuario) {
		newBeaconUsuario.setCreatedAt(new Date());
	    return repository.save(newBeaconUsuario);
    }

	BeaconUsuario one(Integer id) {
		return repository.findById(id)
				.orElseThrow(() -> new BeaconUsuarioNotFoundException(id));
	}

	BeaconUsuario replaceBeaconUsuario(BeaconUsuario entity, Integer id) {
		Optional<BeaconUsuario> optional = repository.findById(id);
		if(!optional.isPresent()) {
			return null;
		}	  
		entity.setId(id);
		entity.setCreatedAt(optional.get().getCreatedAt());
		entity.setUpdatedAt(new Date());
		return repository.save(entity);
	}

	void deleteBeaconUsuario(Integer id) {
		repository.deleteById(id);
	}
	
}
