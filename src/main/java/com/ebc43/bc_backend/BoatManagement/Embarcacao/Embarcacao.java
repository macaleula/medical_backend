package com.ebc43.bc_backend.BoatManagement.Embarcacao;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLDeleteAll;
import org.hibernate.annotations.Where;

import com.ebc43.bc_backend.AbstractEntity.IntegerIdAbstractEntity;
import com.ebc43.bc_backend.BoatManagement.EmbarcacaoProprietario.EmbarcacaoProprietario;
import com.ebc43.bc_backend.BoatManagement.Marina.Marina;
import com.ebc43.bc_backend.BoatManagement.ModeloEmbarcacao.ModeloEmbarcacao;
import com.ebc43.bc_backend.RoutineSaylor.EmbarcacaoMarinheiro.EmbarcacaoMarinheiro;
import com.ebc43.bc_backend.TaskManagement.GrupoTarefa.GrupoTarefa;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="embarcacao")
public class Embarcacao extends IntegerIdAbstractEntity {
	@ManyToOne
	@JoinColumn(name="modelo_embarcacao_id", nullable=false)
	private ModeloEmbarcacao modeloEmbarcacao;
	@Column(nullable=false)
	@Size(max=45)
	private String nome;
	@ManyToOne
	private Marina marina;
	@OneToMany
	@JoinColumn(name="embarcacao_id")
	@JsonManagedReference
	@SQLDelete(sql="update embarcacao_proprietario set deletedAt = now() where embarcacao_id=? and id=?")
	@SQLDeleteAll(sql="update embarcacao_proprietario set deleted_at = now() where embarcacao_id=?")
	@Where(clause="deleted_at is null")
	private List<EmbarcacaoProprietario> embarcacaoProprietarios;
	@OneToMany
	@JoinColumn(name="embarcacao_id")
	@JsonManagedReference
	@SQLDelete(sql="update embarcacao_marinheiro set deleted_at = now() where embarcacao_id=? and id=?")
	@SQLDeleteAll(sql="update embarcacao_marinheiro set deleted_at = now() where embarcacao_id=?")
	@Where(clause="deleted_at is null")
	private List<EmbarcacaoMarinheiro> embarcacaoMarinheiros;
	@OneToMany
	@JoinColumn(name="embarcacao_id")
	@JsonManagedReference
	@SQLDelete(sql="update grupo_tarefa set deleted_at = now() where embarcacao_id=? and id=?")
	@SQLDeleteAll(sql="update grupo_tarefa set deleted_at = now() where embarcacao_id=?")
	@Where(clause="deleted_at is null")
	private List<GrupoTarefa> gruposTarefa;
	@OneToOne
	@JoinColumn(name="grupo_selecionado_id")
	@JsonManagedReference
	private GrupoTarefa grupoSelecionado;
	
	public Embarcacao() {
		super();
	}

	public Embarcacao(Integer id, ModeloEmbarcacao modeloEmbarcacao, @Size(max = 45) String nome, Marina marina,
			List<EmbarcacaoProprietario> embarcacaoProprietarios, List<EmbarcacaoMarinheiro> embarcacaoMarinheiros,
			Date createdAt, Date updatedAt, Date deletedAt) {
		super(id, createdAt, updatedAt, deletedAt);
		this.modeloEmbarcacao = modeloEmbarcacao;
		this.nome = nome;
		this.marina = marina;
		this.embarcacaoProprietarios = embarcacaoProprietarios;
		this.embarcacaoMarinheiros = embarcacaoMarinheiros;
	}

	public ModeloEmbarcacao getModeloEmbarcacao() {
		return modeloEmbarcacao;
	}

	public void setModeloEmbarcacao(ModeloEmbarcacao modeloEmbarcacao) {
		this.modeloEmbarcacao = modeloEmbarcacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Marina getMarina() {
		return marina;
	}

	public void setMarina(Marina marina) {
		this.marina = marina;
	}

	public List<EmbarcacaoProprietario> getEmbarcacaoProprietarios() {
		return embarcacaoProprietarios;
	}

	public void setEmbarcacaoProprietarios(List<EmbarcacaoProprietario> embarcacaoProprietarios) {
		this.embarcacaoProprietarios = embarcacaoProprietarios;
	}

	public List<EmbarcacaoMarinheiro> getEmbarcacaoMarinheiros() {
		return embarcacaoMarinheiros;
	}

	public void setEmbarcacaoMarinheiros(List<EmbarcacaoMarinheiro> embarcacaoMarinheiros) {
		this.embarcacaoMarinheiros = embarcacaoMarinheiros;
	}

	public List<GrupoTarefa> getGruposTarefa() {
		return gruposTarefa;
	}

	public void setGruposTarefa(List<GrupoTarefa> gruposTarefa) {
		this.gruposTarefa = gruposTarefa;
	}

	public GrupoTarefa getGrupoSelecionado() {
		return grupoSelecionado;
	}

	public void setGrupoSelecionado(GrupoTarefa grupoSelecionado) {
		this.grupoSelecionado = grupoSelecionado;
	}
	
}