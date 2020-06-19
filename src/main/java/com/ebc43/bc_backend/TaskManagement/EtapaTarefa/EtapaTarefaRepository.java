package com.ebc43.bc_backend.TaskManagement.EtapaTarefa;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ebc43.bc_backend.SoftDeleteRepository.UUIDSoftDeleteCrudRepository;

public interface EtapaTarefaRepository extends UUIDSoftDeleteCrudRepository<EtapaTarefa, UUID> {
	@Query("SELECT et FROM EtapaTarefa et WHERE et.tarefa.id = :id")
	public List<EtapaTarefa> findAllByTarefaId(@Param("id")UUID id);
	
	@Transactional
    @Modifying
	@Query("UPDATE EtapaTarefa et SET et.deletedAt = CURRENT_TIMESTAMP WHERE et.tarefa.id = :id")
	public void deleteByTarefaId(@Param("id")UUID id);
}
