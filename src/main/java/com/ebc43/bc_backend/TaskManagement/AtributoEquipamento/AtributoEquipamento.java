package com.ebc43.bc_backend.TaskManagement.AtributoEquipamento;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ebc43.bc_backend.AbstractEntity.UUIDAbstractEntity;
import com.ebc43.bc_backend.TaskManagement.Equipamento.Equipamento;
import com.ebc43.bc_backend.TaskManagement.ModeloAtributoEquipamento.ModeloAtributoEquipamento;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="atributo_equipamento")
public class AtributoEquipamento extends UUIDAbstractEntity {
	@ManyToOne
	@JoinColumn(name="modelo_atributo_equipamento_id", nullable=false)
	private ModeloAtributoEquipamento modeloAtributoEquipamento;
	@ManyToOne
	@JoinColumn(name="equipamento_id", nullable=false)
	@JsonBackReference
	private Equipamento equipamento;
	@Column(name="valor", nullable=false)
	private String valor;
	
	public AtributoEquipamento() {
	}

	public AtributoEquipamento(UUID id, ModeloAtributoEquipamento modeloAtributoEquipamento, Equipamento equipamento,
			String valor, Date createdAt, Date updatedAt, Date deletedAt) {
		super(id, createdAt, updatedAt, deletedAt);
		this.modeloAtributoEquipamento = modeloAtributoEquipamento;
		this.equipamento = equipamento;
		this.valor = valor;
	}

	public ModeloAtributoEquipamento getModeloAtributoEquipamento() {
		return modeloAtributoEquipamento;
	}

	public void setModeloAtributoEquipamento(ModeloAtributoEquipamento modeloAtributoEquipamento) {
		this.modeloAtributoEquipamento = modeloAtributoEquipamento;
	}

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	
}
