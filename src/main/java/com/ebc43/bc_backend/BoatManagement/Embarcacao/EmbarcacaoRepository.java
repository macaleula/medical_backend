package com.ebc43.bc_backend.BoatManagement.Embarcacao;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.ebc43.bc_backend.SoftDeleteRepository.IntegerIdSoftDeleteCrudRepository;

public interface EmbarcacaoRepository extends IntegerIdSoftDeleteCrudRepository <Embarcacao, Integer>{
	@Transactional
	@Modifying(clearAutomatically=true)
	@Query("UPDATE Embarcacao e SET e.modeloEmbarcacao = :#{#entity.modeloEmbarcacao}, "
			+ "e.nome = :#{#entity.nome}, e.marina = :#{#entity.marina}, "
			+ "e.grupoSelecionado = :#{#entity.grupoSelecionado}, e.updatedAt = :#{#entity.updatedAt} "
			+ "WHERE e.id = :#{#entity.id}")
	public void update(@Param("entity")Embarcacao entity);
	
	@Query("SELECT e FROM Embarcacao e WHERE LOWER(e.nome) = LOWER(:nome)")
	public Embarcacao findByNome(String nome);			

	@Query("SELECT e FROM Embarcacao e JOIN e.marina m WHERE LOWER(m.nome) = LOWER(:nome)")
	public Embarcacao findByMarina(@Param("nome")String nome);	
	
	// PR
	
	@Query("SELECT e FROM Embarcacao e JOIN e.embarcacaoProprietarios ep "
			+ "WHERE ep.proprietario.informacoesSensiveis.username = :username")
	public List<Embarcacao> findByPrUsername(@Param("username")String username);
	
	// MR
	
	@Query("SELECT e FROM Embarcacao e JOIN e.embarcacaoMarinheiros em "
			+ "WHERE em.marinheiro.informacoesSensiveis.username = :username")
	public List<Embarcacao> findByMrUsername(@Param("username")String username);
	
}