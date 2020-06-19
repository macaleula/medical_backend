package com.ebc43.bc_backend.TaskManagement.PreRequisitoModeloTarefa;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ebc43.bc_backend.AbstractEntity.IntegerIdAbstractEntity;
import com.ebc43.bc_backend.TaskManagement.ModeloTarefa.ModeloTarefa;
import com.ebc43.bc_backend.TaskManagement.ModeloTarefa.ModeloTarefaSerializer;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
@Table(name="pre_requisito_modelo_tarefa")
public class PreRequisitoModeloTarefa extends IntegerIdAbstractEntity {
	@ManyToOne
	@JoinColumn(name="modelo_tarefa_id")
	@JsonBackReference
	private ModeloTarefa modeloTarefa;
	@ManyToOne
	@JoinColumn(name="pre_requisito_id")
	@JsonSerialize(using = ModeloTarefaSerializer.class)
	private ModeloTarefa preRequisito;
	@Column(name="tempo_minimo_sucessao_segundos")
	private Integer tempoMinimoSucessao; 
	@Column(name="tempo_maximo_sucessao_segundos")
	private Integer tempoMaximoSucessao;
	
	public PreRequisitoModeloTarefa() {
	}

	public PreRequisitoModeloTarefa(Integer id, ModeloTarefa modeloTarefa, ModeloTarefa preRequisito,
			Integer tempoMinimoSucessao, Integer tempoMaximoSucessao, Date createdAt, Date updatedAt, Date deletedAt) {
		super(id, createdAt, updatedAt, deletedAt);
		this.modeloTarefa = modeloTarefa;
		this.preRequisito = preRequisito;
		this.tempoMinimoSucessao = tempoMinimoSucessao;
		this.tempoMaximoSucessao = tempoMaximoSucessao;
	}

	public ModeloTarefa getModeloTarefa() {
		return modeloTarefa;
	}

	public void setModeloTarefa(ModeloTarefa modeloTarefa) {
		this.modeloTarefa = modeloTarefa;
	}

	public ModeloTarefa getPreRequisito() {
		return preRequisito;
	}

	public void setPreRequisito(ModeloTarefa preRequisito) {
		this.preRequisito = preRequisito;
	}

	public Integer getTempoMinimoSucessao() {
		return tempoMinimoSucessao;
	}

	public void setTempoMinimoSucessao(Integer tempoMinimoSucessao) {
		this.tempoMinimoSucessao = tempoMinimoSucessao;
	}

	public Integer getTempoMaximoSucessao() {
		return tempoMaximoSucessao;
	}

	public void setTempoMaximoSucessao(Integer tempoMaximoSucessao) {
		this.tempoMaximoSucessao = tempoMaximoSucessao;
	}

}
