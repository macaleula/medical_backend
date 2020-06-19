package com.ebc43.bc_backend.UserManagement.InformacoesSensiveis;

import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class InformacoesSensiveisService {
	private final InformacoesSensiveisRepository repository;

	public InformacoesSensiveisService(InformacoesSensiveisRepository repository) {
		this.repository = repository;
	}

	List<InformacoesSensiveis> all() {
		return (List<InformacoesSensiveis>) repository.findAll();
	}

	InformacoesSensiveis newInformacoesSensiveis(InformacoesSensiveis newInformacoesSensiveis) {
		newInformacoesSensiveis.setCreatedAt(new Date());
	    return repository.save(newInformacoesSensiveis);
    }

	InformacoesSensiveis one(Integer id) {
		return repository.findById(id)
				.orElseThrow(() -> new InformacoesSensiveisNotFoundException(id));
	}

	InformacoesSensiveis replaceInformacoesSensiveis(InformacoesSensiveis entity, Integer id) {
		Optional<InformacoesSensiveis> optional = repository.findById(id);
		if(!optional.isPresent()) {
			return null;
		}	  
		entity.setId(id);
		entity.setCreatedAt(optional.get().getCreatedAt());
		entity.setUpdatedAt(new Date());
		return repository.save(entity);
	}

	void deleteInformacoesSensiveis(Integer id) {
		repository.deleteById(id);
	}
	
}