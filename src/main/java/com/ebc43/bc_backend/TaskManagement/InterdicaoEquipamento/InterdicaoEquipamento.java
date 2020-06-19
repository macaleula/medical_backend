package com.ebc43.bc_backend.TaskManagement.InterdicaoEquipamento;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ebc43.bc_backend.AbstractEntity.UUIDAbstractEntity;
import com.ebc43.bc_backend.TaskManagement.Equipamento.Equipamento;
import com.ebc43.bc_backend.UserManagement.Usuario.Usuario;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="interdicao_equipamento")
public class InterdicaoEquipamento extends UUIDAbstractEntity {
	@ManyToOne
	@JoinColumn(name="equipamento_id",nullable=false)
	@JsonBackReference
	private Equipamento equipamento;
	@ManyToOne
	@JoinColumn(name="usuario_responsavel_mudanca_id",nullable=false)
	private Usuario usuarioResponsavelMudanca;
	@Column(nullable=false)
	private Date dataMudanca;
	@Column(nullable=false)
	private Boolean interditado;
	private String observacao;
	
	public InterdicaoEquipamento() {
	}

	public InterdicaoEquipamento(UUID id, Equipamento equipamento, Usuario usuarioResponsavelMudanca, Date dataMudanca,
			Boolean interditado, String observacao, Date createdAt, Date updatedAt, Date deletedAt) {
		super(id, createdAt, updatedAt, deletedAt);
		this.equipamento = equipamento;
		this.usuarioResponsavelMudanca = usuarioResponsavelMudanca;
		this.dataMudanca = dataMudanca;
		this.interditado = interditado;
		this.observacao = observacao;
	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
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
