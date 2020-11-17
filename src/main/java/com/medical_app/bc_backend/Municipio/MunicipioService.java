package com.medical_app.bc_backend.Municipio;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MunicipioService {
	private final MunicipioRepository repository;

	public MunicipioService(MunicipioRepository repository) {
		this.repository = repository;
	}

	List<Municipio> all() {
		return (List<Municipio>) repository.findAll();
	}

	Municipio newMunicipio(Municipio newEntity) {
	    return repository.save(newEntity);
    }

	Municipio one(Integer id) {
		return repository.findById(id)
				.orElseThrow(() -> new MunicipioNotFoundException(id));
	}

	Municipio replaceMunicipio(Municipio entity, Integer id) {
		Optional<Municipio> optional = repository.findById(id);
		if(!optional.isPresent()) {
			return null;
		}	  
		entity.setCodigoIbge(id);
		return repository.save(entity);
	}

	void deleteMunicipio(Integer id) {
		repository.deleteById(id);
	}

}