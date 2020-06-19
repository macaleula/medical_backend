package com.ebc43.bc_backend.RoutineSaylor.EmbarcacaoMarinheiro;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ebc43.bc_backend.SoftDeleteRepository.IntegerIdSoftDeleteCrudRepository;

public interface EmbarcacaoMarinheiroRepository extends IntegerIdSoftDeleteCrudRepository<EmbarcacaoMarinheiro, Integer>{
	@Transactional
    @Modifying
	@Query("UPDATE EmbarcacaoMarinheiro em SET em.deletedAt = CURRENT_TIMESTAMP WHERE em.marinheiro.id = :id")
	public void deleteByMarinheiroId(@Param("id")Integer id);



	
	
}
