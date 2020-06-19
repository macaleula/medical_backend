package com.ebc43.bc_backend.TaskManagement.MarinheiroEscalado;

import java.util.UUID;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ebc43.bc_backend.SoftDeleteRepository.UUIDSoftDeleteCrudRepository;

public interface MarinheiroEscaladoRepository extends UUIDSoftDeleteCrudRepository<MarinheiroEscalado, UUID>{
	@Transactional
    @Modifying
	@Query("UPDATE MarinheiroEscalado me SET me.deletedAt = CURRENT_TIMESTAMP WHERE me.tarefa.id = :id")
	public void deleteByTarefaId(@Param("id")UUID id);
}
