package com.ebc43.bc_backend.TaskManagement.Equipamento;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import com.ebc43.bc_backend.SoftDeleteRepository.UUIDSoftDeleteCrudRepository;

public interface EquipamentoRepository extends UUIDSoftDeleteCrudRepository<Equipamento, UUID>{

	@Query("SELECT e FROM Equipamento e WHERE e.ambiente.embarcacao.id = :id")
	public List<Equipamento> findAllByEmbarcacao(Integer id);

	@Query("SELECT e FROM Equipamento e WHERE e.ambiente.id = :id")
	public List<Equipamento> findAllByAmbiente(Integer id);
	
	
	// PR
	
	@Query("SELECT e FROM Equipamento e JOIN e.ambiente.embarcacao.embarcacaoProprietarios ep "
			+ "WHERE ep.proprietario.informacoesSensiveis.username = :username")
	public List<Equipamento> findAllByPrUsername(String username);
	
	// MR
	
	@Query("SELECT e FROM Equipamento e JOIN e.ambiente.embarcacao.embarcacaoMarinheiros em "
			+ "WHERE em.marinheiro.informacoesSensiveis.username = :username")
	public List<Equipamento> findAllByMrUsername(String username);
	

}
