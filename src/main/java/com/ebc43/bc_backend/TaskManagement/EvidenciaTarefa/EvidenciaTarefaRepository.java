package com.ebc43.bc_backend.TaskManagement.EvidenciaTarefa;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ebc43.bc_backend.SoftDeleteRepository.UUIDSoftDeleteCrudRepository;

public interface EvidenciaTarefaRepository extends UUIDSoftDeleteCrudRepository<EvidenciaTarefa, UUID>{
	@Transactional
    @Modifying
	@Query("UPDATE EvidenciaTarefa et SET et.deletedAt = CURRENT_TIMESTAMP WHERE et.etapaTarefa.id = :id")
	public void deleteByEtapaTarefaId(@Param("id")UUID id);

	@Query("SELECT et FROM EvidenciaTarefa et WHERE et.etapaTarefa.tarefa.id = :id")
	public List<EvidenciaTarefa> findAllByTarefaId(UUID id);
}