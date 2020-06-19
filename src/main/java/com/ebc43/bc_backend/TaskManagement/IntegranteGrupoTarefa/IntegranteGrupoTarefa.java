package com.ebc43.bc_backend.TaskManagement.IntegranteGrupoTarefa;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ebc43.bc_backend.AbstractEntity.UUIDAbstractEntity;
import com.ebc43.bc_backend.TaskManagement.GrupoTarefa.GrupoTarefa;
import com.ebc43.bc_backend.TaskManagement.ModeloTarefa.ModeloTarefa;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="integrante_grupo_tarefa")
public class IntegranteGrupoTarefa extends UUIDAbstractEntity {
	@ManyToOne
	@JoinColumn(name="modelo_tarefa_id", nullable=false)
	private ModeloTarefa modeloTarefa;
	@ManyToOne
	@JoinColumn(name="grupo_tarefa_id", nullable=false)
	@JsonBackReference
	private GrupoTarefa grupoTarefa;
	
	public IntegranteGrupoTarefa() {
	}

	public IntegranteGrupoTarefa(UUID id, ModeloTarefa modeloTarefa, GrupoTarefa grupoTarefa, Date createdAt,
			Date updatedAt, Date deletedAt) {
		super(id, createdAt, updatedAt, deletedAt);
		this.modeloTarefa = modeloTarefa;
		this.grupoTarefa = grupoTarefa;
	}

	public ModeloTarefa getModeloTarefa() {
		return modeloTarefa;
	}

	public void setModeloTarefa(ModeloTarefa modeloTarefa) {
		this.modeloTarefa = modeloTarefa;
	}

	public GrupoTarefa getGrupoTarefa() {
		return grupoTarefa;
	}

	public void setGrupoTarefa(GrupoTarefa grupoTarefa) {
		this.grupoTarefa = grupoTarefa;
	}
	
}
