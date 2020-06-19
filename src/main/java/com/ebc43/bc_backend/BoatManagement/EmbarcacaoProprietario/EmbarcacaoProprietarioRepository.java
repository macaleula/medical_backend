package com.ebc43.bc_backend.BoatManagement.EmbarcacaoProprietario;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ebc43.bc_backend.SoftDeleteRepository.IntegerIdSoftDeleteCrudRepository;

public interface EmbarcacaoProprietarioRepository extends IntegerIdSoftDeleteCrudRepository<EmbarcacaoProprietario, Integer>{

	@Transactional
    @Modifying
	@Query("UPDATE EmbarcacaoProprietario em SET em.deletedAt = CURRENT_TIMESTAMP WHERE em.proprietario.id = :id")
	public void deleteByProprietarioId(@Param("id")Integer id);




}