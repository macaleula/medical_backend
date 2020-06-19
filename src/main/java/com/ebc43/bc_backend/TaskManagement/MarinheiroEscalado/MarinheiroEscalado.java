package com.ebc43.bc_backend.TaskManagement.MarinheiroEscalado;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ebc43.bc_backend.AbstractEntity.UUIDAbstractEntity;
import com.ebc43.bc_backend.TaskManagement.Tarefa.Tarefa;
import com.ebc43.bc_backend.UserManagement.Usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="marinheiro_escalado")
public class MarinheiroEscalado extends UUIDAbstractEntity {
	@ManyToOne
	@JoinColumn(name="tarefa_id",nullable=false)
	@JsonBackReference
	private Tarefa tarefa;
	@ManyToOne
	@JoinColumn(name="usuario_id",nullable=false)
	private Usuario marinheiro;
	@Column(name="tempo_restante_trabalho_segundos")
	private Integer tempoRestanteTrabalhoSegundos;
	
	public MarinheiroEscalado() {
	}

	public MarinheiroEscalado(UUID id, Tarefa tarefa, Usuario marinheiro, Integer tempoRestanteTrabalhoSegundos,
			Date createdAt, Date updatedAt, Date deletedAt) {
		super(id, createdAt, updatedAt, deletedAt);
		this.tarefa = tarefa;
		this.marinheiro = marinheiro;
		this.tempoRestanteTrabalhoSegundos = tempoRestanteTrabalhoSegundos;
	}

	public Tarefa getTarefa() {
		return tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}

	public Usuario getMarinheiro() {
		return marinheiro;
	}

	public void setMarinheiro(Usuario marinheiro) {
		this.marinheiro = marinheiro;
	}

	public Integer getTempoRestanteTrabalhoSegundos() {
		return tempoRestanteTrabalhoSegundos;
	}

	public void setTempoRestanteTrabalhoSegundos(Integer tempoRestanteTrabalhoSegundos) {
		this.tempoRestanteTrabalhoSegundos = tempoRestanteTrabalhoSegundos;
	}

}
