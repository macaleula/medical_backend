package com.ebc43.bc_backend.BoatManagement.Municipio;

import org.springframework.stereotype.Service;

import java.util.Date;
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

	Municipio newMunicipio(Municipio newMunicipio) {
		newMunicipio.setCreatedAt(new Date());
	    return repository.save(newMunicipio);
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
		entity.setCreatedAt(optional.get().getCreatedAt());
		entity.setUpdatedAt(new Date());
		return repository.save(entity);
	}

	void deleteMunicipio(Integer id) {
		repository.deleteById(id);
	}

}