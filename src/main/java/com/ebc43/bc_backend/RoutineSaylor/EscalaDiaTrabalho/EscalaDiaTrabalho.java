package com.ebc43.bc_backend.RoutineSaylor.EscalaDiaTrabalho;

import java.util.Date;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ebc43.bc_backend.AbstractEntity.UUIDAbstractEntity;
import com.ebc43.bc_backend.RoutineSaylor.DiaSemana.DiaSemana;
import com.ebc43.bc_backend.RoutineSaylor.EmbarcacaoMarinheiro.EmbarcacaoMarinheiro;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="escala_dia_trabalho")
public class EscalaDiaTrabalho extends UUIDAbstractEntity {
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="embarcacao_marinheiro_id",nullable=false)
	@JsonBackReference
	private EmbarcacaoMarinheiro embarcacaoMarinheiro;
	@ManyToOne
	@JoinColumn(name="dia_semana_id",nullable=false)
	private DiaSemana diaSemana;
	@Column(name="hora_entrada",nullable=false)
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	private Date horaEntrada;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm")
	@Column(name="hora_saida",nullable=false)
	private Date horaSaida;
	
	public EscalaDiaTrabalho() {
		super();
	}

	public EscalaDiaTrabalho(UUID id, EmbarcacaoMarinheiro embarcacaoMarinheiro, DiaSemana diaSemana, Date horaEntrada,
			Date horaSaida, Date createdAt, Date updatedAt, Date deletedAt) {
		super(id, createdAt, updatedAt, deletedAt);
		this.embarcacaoMarinheiro = embarcacaoMarinheiro;
		this.diaSemana = diaSemana;
		this.horaEntrada = horaEntrada;
		this.horaSaida = horaSaida;
	}

	public EmbarcacaoMarinheiro getEmbarcacaoMarinheiro() {
		return embarcacaoMarinheiro;
	}

	public void setEmbarcacaoMarinheiro(EmbarcacaoMarinheiro embarcacaoMarinheiro) {
		this.embarcacaoMarinheiro = embarcacaoMarinheiro;
	}

	public DiaSemana getDiaSemana() {
		return diaSemana;
	}

	public void setDiaSemana(DiaSemana diaSemana) {
		this.diaSemana = diaSemana;
	}

	public Date getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(Date horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public Date getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(Date horaSaida) {
		this.horaSaida = horaSaida;
	}

	
}
