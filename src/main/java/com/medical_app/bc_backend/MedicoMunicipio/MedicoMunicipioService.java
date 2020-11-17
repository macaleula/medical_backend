package com.medical_app.bc_backend.MedicoMunicipio;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class MedicoMunicipioService {
	private final MedicoMunicipioRepository repository;

	public MedicoMunicipioService(MedicoMunicipioRepository repository) {
		this.repository = repository;
	}

	List<MedicoMunicipio> all() {
		return (List<MedicoMunicipio>) repository.findAll();
	}

	MedicoMunicipio newMedicoMunicipio(MedicoMunicipio newEntity) {
	    return repository.save(newEntity);
    }

	MedicoMunicipio one(Integer id) {
		return repository.findById(id)
				.orElseThrow(() -> new MedicoMunicipioNotFoundException(id));
	}

	MedicoMunicipio replaceMedicoMunicipio(MedicoMunicipio entity, Integer id) {
		Optional<MedicoMunicipio> optional = repository.findById(id);
		if(!optional.isPresent()) {
			return null;
		}	  
		entity.setId(id);
		return repository.save(entity);
	}

	void deleteMedicoMunicipio(Integer id) {
		repository.deleteById(id);
	}
}
