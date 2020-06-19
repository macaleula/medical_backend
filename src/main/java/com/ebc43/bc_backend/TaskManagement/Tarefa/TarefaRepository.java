package com.ebc43.bc_backend.TaskManagement.Tarefa;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import com.ebc43.bc_backend.SoftDeleteRepository.UUIDSoftDeleteCrudRepository;

public interface TarefaRepository extends UUIDSoftDeleteCrudRepository<Tarefa, UUID>{
	// PR
	
	@Query("SELECT distinct t FROM Tarefa t JOIN t.equipamento.ambiente.embarcacao.embarcacaoProprietarios ep "
			+ "WHERE ep.proprietario.informacoesSensiveis.username = :username ")
	public List<Tarefa> findOperantesByPrUsername(String username);

	@Query("SELECT t FROM Tarefa t JOIN t.etapaTarefa et " 
			+ "JOIN t.equipamento.ambiente.embarcacao.embarcacaoProprietarios ep " 
			+ "WHERE et.estadoTarefa.id = 13 AND t.modeloTarefa.id = :modeloTarefaId " 
			+ "AND ep.proprietario.informacoesSensiveis.username = :username")
	public List<Tarefa> findFinalizadasByModeloTarefaAndPrUsername(Integer modeloTarefaId, String username);
	
	// MR
	
	@Query("SELECT t FROM Tarefa t JOIN t.marinheirosEscalados me " 
			+ "WHERE me.marinheiro.informacoesSensiveis.username = :username")
	public List<Tarefa> findOperantesByMrUsername(String username);
	
	@Query("SELECT t FROM Tarefa t JOIN t.etapaTarefa et " 
			+ "JOIN t.marinheirosEscalados me " 
			+ "WHERE et.estadoTarefa.id = 13 AND t.modeloTarefa.id = :modeloTarefaId " 
			+ "AND me.marinheiro.informacoesSensiveis.username = :username")
	public List<Tarefa> findFinalizadasByModeloTarefaAndMrUsername(Integer modeloTarefaId, String username);

	@Query("SELECT t FROM Tarefa t WHERE t.equipamento.ambiente.embarcacao.id = :embarcacaoId")
	public List<Tarefa> findAllByEmbarcacao(Integer embarcacaoId);

	@Query("SELECT t FROM Tarefa t WHERE t.equipamento.ambiente.id = :ambienteId")
	public List<Tarefa> findAllByAmbiente(Integer ambienteId);
	
}
