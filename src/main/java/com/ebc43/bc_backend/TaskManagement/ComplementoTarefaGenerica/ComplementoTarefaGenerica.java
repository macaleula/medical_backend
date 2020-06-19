package com.ebc43.bc_backend.TaskManagement.ComplementoTarefaGenerica;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ebc43.bc_backend.AbstractEntity.UUIDAbstractEntity;
import com.ebc43.bc_backend.TaskManagement.Tarefa.Tarefa;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="complemento_tarefa_generica")
public class ComplementoTarefaGenerica extends UUIDAbstractEntity {
	@OneToOne
	@JoinColumn(nullable=false)
	@JsonBackReference
	private Tarefa tarefa;
	@Column(nullable=false)
	private String nome;
	@Column(nullable=false)
	private String descricao;
	@Column(name="tempo_proposto_trabalho_segundos",nullable=false)
	private Integer tempoPropostoTrabalhoSegundos;
	@Column(name="tempo_aprovado_trabalho_segundos")
	private Integer tempoAprovadoTrabalhoSegundos;
	
	public ComplementoTarefaGenerica() {
		super();
	}

	public ComplementoTarefaGenerica(UUID id, Tarefa tarefa, String nome, String descricao,
			Integer tempoPropostoTrabalhoSegundos, Integer tempoAprovadoTrabalhoSegundos, Date createdAt,
			Date updatedAt, Date deletedAt) {
		super(id, createdAt, updatedAt, deletedAt);
		this.tarefa = tarefa;
		this.nome = nome;
		this.descricao = descricao;
		this.tempoPropostoTrabalhoSegundos = tempoPropostoTrabalhoSegundos;
		this.tempoAprovadoTrabalhoSegundos = tempoAprovadoTrabalhoSegundos;
	}


	public Tarefa getTarefa() {
		return tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getTempoPropostoTrabalhoSegundos() {
		return tempoPropostoTrabalhoSegundos;
	}

	public void setTempoPropostoTrabalhoSegundos(Integer tempoPropostoTrabalhoSegundos) {
		this.tempoPropostoTrabalhoSegundos = tempoPropostoTrabalhoSegundos;
	}

	public Integer getTempoAprovadoTrabalhoSegundos() {
		return tempoAprovadoTrabalhoSegundos;
	}

	public void setTempoAprovadoTrabalhoSegundos(Integer tempoAprovadoTrabalhoSegundos) {
		this.tempoAprovadoTrabalhoSegundos = tempoAprovadoTrabalhoSegundos;
	}
}
