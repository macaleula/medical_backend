package com.ebc43.bc_backend.TaskManagement.ModeloTarefa;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLDeleteAll;
import org.hibernate.annotations.Where;

import com.ebc43.bc_backend.AbstractEntity.IntegerIdAbstractEntity;
import com.ebc43.bc_backend.TaskManagement.EvidenciaNecessariaTarefa.EvidenciaNecessariaTarefa;
import com.ebc43.bc_backend.TaskManagement.ModeloEquipamento.ModeloEquipamento;
import com.ebc43.bc_backend.TaskManagement.PosRequisitoModeloTarefa.PosRequisitoModeloTarefa;
import com.ebc43.bc_backend.TaskManagement.PreRequisitoModeloTarefa.PreRequisitoModeloTarefa;
import com.ebc43.bc_backend.TaskManagement.RecursoHumanoModeloTarefa.RecursoHumanoModeloTarefa;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="modelo_tarefa")
public class ModeloTarefa extends IntegerIdAbstractEntity {
	@ManyToOne
	@JoinColumn(name="modelo_equipamento_id", nullable=false)
	private ModeloEquipamento modeloEquipamento;
	@Column(nullable=false)
	@Size(max=45)
	private String nome;
	@Column(name="periodicidade_dias",nullable=false)
	private Integer periodicidadeDias;
	@OneToMany
	@JoinColumn(name="modelo_tarefa_id")
	@OrderBy("numeroMarinheirosAlocados ASC")
	@JsonManagedReference
	@SQLDelete(sql="update recurso_humano_modelo_tarefa set deleted_at = now() where modelo_tarefa_id=? and id=?")
	@SQLDeleteAll(sql="update recurso_humano_modelo_tarefa set deleted_at = now() where modelo_tarefa_id=?")
	@Where(clause="deleted_at is null")
	private List<RecursoHumanoModeloTarefa> recursosHumanosModeloTarefa;
	@OneToMany
	@JoinColumn(name="modelo_tarefa_id")
	@JsonManagedReference
	@SQLDelete(sql="update evidencia_necessaria set deleted_at = now() where modelo_tarefa_id=? and id=?")
	@SQLDeleteAll(sql="update evidencia_necessaria set deleted_at = now() where modelo_tarefa_id=?")
	@Where(clause="deleted_at is null")
	private List<EvidenciaNecessariaTarefa> evidenciasNecessariasTarefa;
	@OneToMany
	@JoinColumn(name="modelo_tarefa_id")
	@JsonManagedReference
	@SQLDelete(sql="update pre_requisito_modelo_tarefa set deleted_at = now() where modelo_tarefa_id=? and id=?")
	@SQLDeleteAll(sql="update pre_requisito_modelo_tarefa set deleted_at = now() where modelo_tarefa_id=?")
	@Where(clause="deleted_at is null")
	private List<PreRequisitoModeloTarefa> preRequisitosModeloTarefa;
	@OneToMany
	@JoinColumn(name="modelo_tarefa_id")
	@JsonManagedReference
	@SQLDelete(sql="update pos_requisito_modelo_tarefa set deleted_at = now() where modelo_tarefa_id=? and id=?")
	@SQLDeleteAll(sql="update pos_requisito_modelo_tarefa set deleted_at = now() where modelo_tarefa_id=?")
	@Where(clause="deleted_at is null")
	private List<PosRequisitoModeloTarefa> posRequisitosModeloTarefa;
	@Column(name="endereco_instrucao", nullable=false)
	private String enderecoInstrucao;
	
	public ModeloTarefa() {
	}

	public ModeloTarefa(Integer id, ModeloEquipamento modeloEquipamento, @Size(max = 45) String nome,
			Integer periodicidadeDias, List<RecursoHumanoModeloTarefa> recursosHumanosModeloTarefa,
			List<EvidenciaNecessariaTarefa> evidenciasNecessariasTarefa,
			List<PreRequisitoModeloTarefa> preRequisitosModeloTarefa,
			List<PosRequisitoModeloTarefa> posRequisitosModeloTarefa, String enderecoInstrucao, Date createdAt,
			Date updatedAt, Date deletedAt) {
		super(id, createdAt, updatedAt, deletedAt);
		this.modeloEquipamento = modeloEquipamento;
		this.nome = nome;
		this.periodicidadeDias = periodicidadeDias;
		this.recursosHumanosModeloTarefa = recursosHumanosModeloTarefa;
		this.evidenciasNecessariasTarefa = evidenciasNecessariasTarefa;
		this.preRequisitosModeloTarefa = preRequisitosModeloTarefa;
		this.posRequisitosModeloTarefa = posRequisitosModeloTarefa;
		this.enderecoInstrucao = enderecoInstrucao;
	}

	public ModeloEquipamento getModeloEquipamento() {
		return modeloEquipamento;
	}

	public void setModeloEquipamento(ModeloEquipamento modeloEquipamento) {
		this.modeloEquipamento = modeloEquipamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getPeriodicidadeDias() {
		return periodicidadeDias;
	}

	public void setPeriodicidadeDias(Integer periodicidadeDias) {
		this.periodicidadeDias = periodicidadeDias;
	}

	public List<RecursoHumanoModeloTarefa> getRecursosHumanosModeloTarefa() {
		return recursosHumanosModeloTarefa;
	}

	public void setRecursosHumanosModeloTarefa(List<RecursoHumanoModeloTarefa> recursosHumanosModeloTarefa) {
		this.recursosHumanosModeloTarefa = recursosHumanosModeloTarefa;
	}

	public List<EvidenciaNecessariaTarefa> getEvidenciasNecessariasTarefa() {
		return evidenciasNecessariasTarefa;
	}

	public void setEvidenciasNecessariasTarefa(List<EvidenciaNecessariaTarefa> evidenciasNecessariasTarefa) {
		this.evidenciasNecessariasTarefa = evidenciasNecessariasTarefa;
	}

	public List<PreRequisitoModeloTarefa> getPreRequisitosModeloTarefa() {
		return preRequisitosModeloTarefa;
	}

	public void setPreRequisitosModeloTarefa(List<PreRequisitoModeloTarefa> preRequisitosModeloTarefa) {
		this.preRequisitosModeloTarefa = preRequisitosModeloTarefa;
	}

	public List<PosRequisitoModeloTarefa> getPosRequisitosModeloTarefa() {
		return posRequisitosModeloTarefa;
	}

	public void setPosRequisitosModeloTarefa(List<PosRequisitoModeloTarefa> posRequisitosModeloTarefa) {
		this.posRequisitosModeloTarefa = posRequisitosModeloTarefa;
	}

	public String getEnderecoInstrucao() {
		return enderecoInstrucao;
	}

}