package com.ebc43.bc_backend.TaskManagement.Ambiente;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.ebc43.bc_backend.SoftDeleteRepository.IntegerIdSoftDeleteCrudRepository;


public interface AmbienteRepository extends IntegerIdSoftDeleteCrudRepository<Ambiente, Integer>{
	// PR
	
	@Query("SELECT a FROM Ambiente a JOIN a.embarcacao.embarcacaoProprietarios ep "
			+ "WHERE ep.proprietario.informacoesSensiveis.username = :username")
	public List<Ambiente> findByPrUsername(@Param("username")String username);
	
	// MR
	
	@Query("SELECT a FROM Ambiente a JOIN a.embarcacao.embarcacaoMarinheiros em "
			+ "WHERE em.marinheiro.informacoesSensiveis.username = :username")
	public List<Ambiente> findByMrUsername(@Param("username")String username);
}