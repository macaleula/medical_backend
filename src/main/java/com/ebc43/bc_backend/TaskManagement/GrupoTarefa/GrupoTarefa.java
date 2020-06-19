package com.ebc43.bc_backend.TaskManagement.GrupoTarefa;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLDeleteAll;
import org.hibernate.annotations.Where;

import com.ebc43.bc_backend.AbstractEntity.UUIDAbstractEntity;
import com.ebc43.bc_backend.BoatManagement.Embarcacao.Embarcacao;
import com.ebc43.bc_backend.TaskManagement.IntegranteGrupoTarefa.IntegranteGrupoTarefa;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="grupo_tarefa")
//@SQLDelete(sql="update grupo_tarefa set deleted_at = now() where embarcacao_id=? and id=?")
public class GrupoTarefa extends UUIDAbstractEntity {
	@ManyToOne
	@JoinColumn(name="embarcacao_id", nullable=false)
	@JsonBackReference
	private Embarcacao embarcacao;
	@Column(name="nome", nullable=false)
	private String nome;
	@OneToMany
	@JoinColumn(name="grupo_tarefa_id")
	@JsonManagedReference
	@SQLDelete(sql="update integrante_grupo_tarefa set deleted_at = now() where grupo_tarefa_id=? and id=?")
	@SQLDeleteAll(sql="update integrante_grupo_tarefa set deleted_at = now() where grupo_tarefa_id=?")
	@Where(clause="deleted_at is null")
	private List<IntegranteGrupoTarefa> integrantesGrupoTarefa;
	
	public GrupoTarefa() {
	}

	public GrupoTarefa(UUID id, Embarcacao embarcacao, String nome, List<IntegranteGrupoTarefa> integrantesGrupoTarefa,
			Date createdAt, Date updatedAt, Date deletedAt) {
		super(id, createdAt, updatedAt, deletedAt);
		this.embarcacao = embarcacao;
		this.nome = nome;
		this.integrantesGrupoTarefa = integrantesGrupoTarefa;
	}

	public Embarcacao getEmbarcacao() {
		return embarcacao;
	}

	public void setEmbarcacao(Embarcacao embarcacao) {
		this.embarcacao = embarcacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<IntegranteGrupoTarefa> getIntegrantesGrupoTarefa() {
		return integrantesGrupoTarefa;
	}

	public void setIntegrantesGrupoTarefa(List<IntegranteGrupoTarefa> integrantesGrupoTarefa) {
		this.integrantesGrupoTarefa = integrantesGrupoTarefa;
	}

}
