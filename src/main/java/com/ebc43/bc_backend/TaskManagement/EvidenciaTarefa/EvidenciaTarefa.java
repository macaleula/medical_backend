package com.ebc43.bc_backend.TaskManagement.EvidenciaTarefa;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.ebc43.bc_backend.AbstractEntity.UUIDAbstractEntity;
import com.ebc43.bc_backend.TaskManagement.EtapaTarefa.EtapaTarefa;
import com.ebc43.bc_backend.TaskManagement.ModeloEvidenciaTarefa.ModeloEvidenciaTarefa;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="evidencia_tarefa")
public class EvidenciaTarefa extends UUIDAbstractEntity {
	@ManyToOne
	@JoinColumn(name="etapa_tarefa_id", nullable=false)
	@JsonBackReference
	private EtapaTarefa etapaTarefa;
	@ManyToOne
	@JoinColumn(name="modelo_evidencia_tarefa_id", nullable=false)
	private ModeloEvidenciaTarefa modelo;
	@Column(name="endereco_midia",nullable=false)
	@Size(max=100)
	private String enderecoMidia;
	@Column(name="observacao")
	@Size(max=500)
	private String oservacao;
	
	public EvidenciaTarefa() {
	}

	public EvidenciaTarefa(UUID id, EtapaTarefa etapaTarefa, ModeloEvidenciaTarefa modelo,
			@Size(max = 100) String enderecoMidia, @Size(max = 500) String oservacao, Date createdAt, Date updatedAt,
			Date deletedAt) {
		super(id, createdAt, updatedAt, deletedAt);
		this.etapaTarefa = etapaTarefa;
		this.modelo = modelo;
		this.enderecoMidia = enderecoMidia;
		this.oservacao = oservacao;
	}

	public EtapaTarefa getEtapaTarefa() {
		return etapaTarefa;
	}

	public void setEtapaTarefa(EtapaTarefa etapaTarefa) {
		this.etapaTarefa = etapaTarefa;
	}

	public ModeloEvidenciaTarefa getModelo() {
		return modelo;
	}

	public void setModelo(ModeloEvidenciaTarefa modelo) {
		this.modelo = modelo;
	}

	public String getEnderecoMidia() {
		return enderecoMidia;
	}

	public void setEnderecoMidia(String enderecoMidia) {
		this.enderecoMidia = enderecoMidia;
	}

	public String getOservacao() {
		return oservacao;
	}

	public void setOservacao(String oservacao) {
		this.oservacao = oservacao;
	}

}