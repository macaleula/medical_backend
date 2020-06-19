package com.ebc43.bc_backend.RoutineSaylor.EmbarcacaoMarinheiro;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLDeleteAll;
import org.hibernate.annotations.Where;

import com.ebc43.bc_backend.AbstractEntity.IntegerIdAbstractEntity;
import com.ebc43.bc_backend.BoatManagement.Embarcacao.Embarcacao;
import com.ebc43.bc_backend.RoutineSaylor.EscalaDiaTrabalho.EscalaDiaTrabalho;
import com.ebc43.bc_backend.UserManagement.Usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="embarcacao_marinheiro")
public class EmbarcacaoMarinheiro extends IntegerIdAbstractEntity {
	@ManyToOne
	@JoinColumn(name="embarcacao_id",nullable=false)
	@JsonBackReference
	private Embarcacao embarcacao;
	@ManyToOne
	@JoinColumn(name="marinheiro_id",nullable=false)
	private Usuario marinheiro;
	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinColumn(name="embarcacao_marinheiro_id")
	@OrderBy("diaSemana.id ASC, horaEntrada ASC")
	@JsonManagedReference
	@SQLDelete(sql="update escala_dia_trabalho set deleted_at = now() where embarcacao_marinheiro_id=? and id=?")
	@SQLDeleteAll(sql="update escala_dia_trabalho set deleted_at = now() where embarcacao_marinheiro_id=?")
	@Where(clause="deleted_at is null")
	private List<EscalaDiaTrabalho> escalasDiaTrabalho;
	@Column(nullable=false)
	private Integer hierarquia;
	
	public EmbarcacaoMarinheiro() {
	}

	public EmbarcacaoMarinheiro(Integer id, Embarcacao embarcacao, Usuario marinheiro,
			List<EscalaDiaTrabalho> escalasDiaTrabalho, Integer hierarquia, Date createdAt, Date updatedAt,
			Date deletedAt) {
		super(id, createdAt, updatedAt, deletedAt);
		this.embarcacao = embarcacao;
		this.marinheiro = marinheiro;
		this.escalasDiaTrabalho = escalasDiaTrabalho;
		this.hierarquia = hierarquia;
	}

	public Embarcacao getEmbarcacao() {
		return embarcacao;
	}

	public void setEmbarcacao(Embarcacao embarcacao) {
		this.embarcacao = embarcacao;
	}

	public Usuario getMarinheiro() {
		return marinheiro;
	}

	public void setMarinheiro(Usuario marinheiro) {
		this.marinheiro = marinheiro;
	}

	public List<EscalaDiaTrabalho> getEscalasDiaTrabalho() {
		return escalasDiaTrabalho;
	}

	public void setEscalasDiaTrabalho(List<EscalaDiaTrabalho> escalasDiaTrabalho) {
		this.escalasDiaTrabalho = escalasDiaTrabalho;
	}

	public Integer getHierarquia() {
		return hierarquia;
	}

	public void setHierarquia(Integer hierarquia) {
		this.hierarquia = hierarquia;
	}

}
	