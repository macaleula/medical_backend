package com.ebc43.bc_backend.TaskManagement.RecursoHumanoModeloTarefa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ebc43.bc_backend.AbstractEntity.IntegerIdAbstractEntity;
import com.ebc43.bc_backend.TaskManagement.ModeloTarefa.ModeloTarefa;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="recurso_humano_modelo_tarefa")
public class RecursoHumanoModeloTarefa extends IntegerIdAbstractEntity {
	@ManyToOne
	@JoinColumn(name="modelo_tarefa_id",nullable=false)
	@JsonBackReference
	private ModeloTarefa modeloTarefa;
	@Column(name="numero_marinheiros_alocados",nullable=false)
	private Integer numeroMarinheirosAlocados;
	@Column(name="tempo_estimado_trabalho_segundos",nullable=false)
	private Integer tempoEstimadoTrabalhoSegundos;
	
	public RecursoHumanoModeloTarefa() {
	}

	public RecursoHumanoModeloTarefa(Integer id, ModeloTarefa modeloTarefa, Integer numeroMarinheirosAlocados,
			Integer tempoEstimadoTrabalhoSegundos, Date createdAt, Date updatedAt, Date deletedAt) {
		super(id, createdAt, updatedAt, deletedAt);
		this.modeloTarefa = modeloTarefa;
		this.numeroMarinheirosAlocados = numeroMarinheirosAlocados;
		this.tempoEstimadoTrabalhoSegundos = tempoEstimadoTrabalhoSegundos;
	}

	public ModeloTarefa getModeloTarefa() {
		return modeloTarefa;
	}

	public void setModeloTarefa(ModeloTarefa modeloTarefa) {
		this.modeloTarefa = modeloTarefa;
	}

	public Integer getNumeroMarinheirosAlocados() {
		return numeroMarinheirosAlocados;
	}

	public void setNumeroMarinheirosAlocados(Integer numeroMarinheirosAlocados) {
		this.numeroMarinheirosAlocados = numeroMarinheirosAlocados;
	}

	public Integer getTempoEstimadoTrabalhoSegundos() {
		return tempoEstimadoTrabalhoSegundos;
	}

	public void setTempoEstimadoTrabalhoSegundos(Integer tempoEstimadoTrabalhoSegundos) {
		this.tempoEstimadoTrabalhoSegundos = tempoEstimadoTrabalhoSegundos;
	}

}
