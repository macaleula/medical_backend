package com.ebc43.bc_backend.TaskManagement.Equipamento;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.ebc43.bc_backend.BoatManagement.Embarcacao.EmbarcacaoRepository;
import com.ebc43.bc_backend.Security.IAuthenticationFacade;
import com.ebc43.bc_backend.TaskManagement.Ambiente.AmbienteRepository;

public abstract class EquipamentoService {
	@Autowired
    private IAuthenticationFacade authenticationFacade;
	
	private final EquipamentoRepository repository;
	private final EmbarcacaoRepository embarcacaoRepository;
	private final AmbienteRepository ambienteRepository;

	public EquipamentoService(EquipamentoRepository repository, EmbarcacaoRepository embarcacaoRepository,
			AmbienteRepository ambienteRepository) {
		this.repository = repository;
		this.embarcacaoRepository = embarcacaoRepository;
		this.ambienteRepository = ambienteRepository;
	}		

	List<Equipamento> all() {
		return (List<Equipamento>) repository.findAll();
	}

	List<Equipamento> allByEmbarcacaoId(Integer embarcacaoId) {
		return (List<Equipamento>) repository.findAllByEmbarcacao(embarcacaoId);
	}

	List<Equipamento> allByAmbienteId(Integer ambienteId) {
		return (List<Equipamento>) repository.findAllByAmbiente(ambienteId);
	}
	
	Equipamento newEquipamento(Equipamento newEquipamento) {
		newEquipamento.setCreatedAt(new Date());
	    return repository.save(newEquipamento);
    }

	Equipamento one(UUID id) {
		return repository.findById(id)
				.orElseThrow(() -> new EquipamentoNotFoundException(id));
	}

	Equipamento replaceEquipamento(Equipamento entity, UUID id) {
		Optional<Equipamento> optional = repository.findById(id);
		if(!optional.isPresent()) {
			return null;
		}	  
		entity.setId(id);
		entity.setCreatedAt(optional.get().getCreatedAt());
		entity.setUpdatedAt(new Date());
		return repository.save(entity);
	}

	void deleteEquipamento(UUID id) {
		repository.deleteById(id);
	}

	public EquipamentoRepository getRepository() {
		return repository;
	}

	public EmbarcacaoRepository getEmbarcacaoRepository() {
		return embarcacaoRepository;
	}

	public AmbienteRepository getAmbienteRepository() {
		return ambienteRepository;
	}

	public IAuthenticationFacade getAuthenticationFacade() {
		return authenticationFacade;
	}
	  
}