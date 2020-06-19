package com.ebc43.bc_backend.TaskManagement.EvidenciaNecessariaTarefa;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ebc43.bc_backend.AbstractEntity.IntegerIdAbstractEntity;
import com.ebc43.bc_backend.TaskManagement.ModeloEvidenciaTarefa.ModeloEvidenciaTarefa;
import com.ebc43.bc_backend.TaskManagement.ModeloTarefa.ModeloTarefa;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="evidencia_necessaria_tarefa")
public class EvidenciaNecessariaTarefa extends IntegerIdAbstractEntity {
	@ManyToOne
	@JoinColumn(name="modelo_tarefa_id",nullable=false)
	@JsonBackReference
	private ModeloTarefa modeloTarefa;
	@ManyToOne
	@JoinColumn(name="modelo_evidencia_tarefa_id",nullable=false)
	private ModeloEvidenciaTarefa modeloEvidenciaTarefa;
	
	public EvidenciaNecessariaTarefa() {
	}

	public EvidenciaNecessariaTarefa(Integer id, ModeloTarefa modeloTarefa, ModeloEvidenciaTarefa modeloEvidenciaTarefa,
			Date createdAt, Date updatedAt, Date deletedAt) {
		super(id, createdAt, updatedAt, deletedAt);
		this.modeloTarefa = modeloTarefa;
		this.modeloEvidenciaTarefa = modeloEvidenciaTarefa;
	}
	
	public ModeloTarefa getModeloTarefa() {
		return modeloTarefa;
	}

	public void setModeloTarefa(ModeloTarefa modeloTarefa) {
		this.modeloTarefa = modeloTarefa;
	}

	public ModeloEvidenciaTarefa getModeloEvidenciaTarefa() {
		return modeloEvidenciaTarefa;
	}

	public void setModeloEvidenciaTarefa(ModeloEvidenciaTarefa modeloEvidenciaTarefa) {
		this.modeloEvidenciaTarefa = modeloEvidenciaTarefa;
	}

}
