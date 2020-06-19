package com.ebc43.bc_backend.RoutineSaylor.DiaMarinheiro;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.ebc43.bc_backend.AbstractEntity.UUIDAbstractEntity;
import com.ebc43.bc_backend.RoutineSaylor.DiaSemana.DiaSemana;
import com.ebc43.bc_backend.RoutineSaylor.EstadoDiaMarinheiro.EstadoDiaMarinheiro;
import com.ebc43.bc_backend.UserManagement.Usuario.Usuario;

@Entity
@Table(name="dia_marinheiro")
public class DiaMarinheiro extends UUIDAbstractEntity {
	@ManyToOne
	@JoinColumn(name="marinheiro_id",nullable=false)
	private Usuario marinheiro;
	@ManyToOne
	@JoinColumn(name="dia_semana_id",nullable=false)
	private DiaSemana diaSemana;
	@ManyToOne
	@JoinColumn(name="estado_dia_id",nullable=false)
	private EstadoDiaMarinheiro estado;
	@Column(name="is_feriado",nullable=false)
	private Boolean isFeriado;
	@Column(name="hora_chegada")
	private Date horaChegada;
	@Column(name="hora_saida")
	private Date horaSaida;
	@Size(max=500)
	private String observacao;
	private Date dia;
	
	public DiaMarinheiro() {
		super();
	}

	public DiaMarinheiro(UUID id, Usuario marinheiro, DiaSemana diaSemana, EstadoDiaMarinheiro estado,
			Boolean isFeriado, Date horaChegada, Date horaSaida, @Size(max = 500) String observacao, Date dia,
			Date createdAt, Date updatedAt, Date deletedAt) {
		super(id, createdAt, updatedAt, deletedAt);
		this.marinheiro = marinheiro;
		this.diaSemana = diaSemana;
		this.estado = estado;
		this.isFeriado = isFeriado;
		this.horaChegada = horaChegada;
		this.horaSaida = horaSaida;
		this.observacao = observacao;
		this.dia = dia;
	}
	
	public Usuario getMarinheiro() {
		return marinheiro;
	}

	public void setMarinheiro(Usuario marinheiro) {
		this.marinheiro = marinheiro;
	}

	public DiaSemana getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(DiaSemana diaSemana) {
		this.diaSemana = diaSemana;
	}

	public EstadoDiaMarinheiro getEstado() {
		return estado;
	}

	public void setEstado(EstadoDiaMarinheiro estado) {
		this.estado = estado;
	}

	public Boolean getIsFeriado() {
		return isFeriado;
	}

	public void setIsFeriado(Boolean isFeriado) {
		this.isFeriado = isFeriado;
	}

	public Date getHoraChegada() {
		return horaChegada;
	}

	public void setHoraChegada(Date horaChegada) {
		this.horaChegada = horaChegada;
	}

	public Date getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(Date horaSaida) {
		this.horaSaida = horaSaida;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Date getDia() {
		return dia;
	}

	public void setDia(Date dia) {
		this.dia = dia;
	}

}