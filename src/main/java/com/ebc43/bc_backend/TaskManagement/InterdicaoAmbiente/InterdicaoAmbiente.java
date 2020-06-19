package com.ebc43.bc_backend.TaskManagement.InterdicaoAmbiente;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ebc43.bc_backend.AbstractEntity.UUIDAbstractEntity;
import com.ebc43.bc_backend.TaskManagement.Ambiente.Ambiente;
import com.ebc43.bc_backend.UserManagement.Usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="interdicao_ambiente")
public class InterdicaoAmbiente extends UUIDAbstractEntity {
	@ManyToOne
	@JoinColumn(name="ambiente_id",nullable=false)
	@JsonBackReference
	private Ambiente ambiente;
	@ManyToOne
	@JoinColumn(name="usuario_responsavel_mudanca_id",nullable=false)
	private Usuario usuarioResponsavelMudanca;
	@Column(nullable=false)
	private Date dataMudanca;
	@Column(nullable=false)
	private Boolean interditado;
	private String observacao;
	
	public InterdicaoAmbiente() {
	}

	public InterdicaoAmbiente(UUID id, Ambiente ambiente, Usuario usuarioResponsavelMudanca, Date dataMudanca,
			Boolean interditado, String observacao, Date createdAt, Date updatedAt, Date deletedAt) {
		super(id, createdAt, updatedAt, deletedAt);
		this.ambiente = ambiente;
		this.usuarioResponsavelMudanca = usuarioResponsavelMudanca;
		this.dataMudanca = dataMudanca;
		this.interditado = interditado;
		this.observacao = observacao;
	}

	public Ambiente getAmbiente() {
		return ambiente;
	}

	public void setAmbiente(Ambiente ambiente) {
		this.ambiente = ambiente;
	}

	public Usuario getUsuarioResponsavelMudanca() {
		return usuarioResponsavelMudanca;
	}

	public void setUsuarioResponsavelMudanca(Usuario usuarioResponsavelMudanca) {
		this.usuarioResponsavelMudanca = usuarioResponsavelMudanca;
	}

	public Date getDataMudanca() {
		return dataMudanca;
	}

	public void setDataMudanca(Date dataMudanca) {
		this.dataMudanca = dataMudanca;
	}

	public Boolean getInterditado() {
		return interditado;
	}

	public void setInterditado(Boolean interditado) {
		this.interditado = interditado;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

}
