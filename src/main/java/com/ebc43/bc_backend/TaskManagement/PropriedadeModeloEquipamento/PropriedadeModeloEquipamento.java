package com.ebc43.bc_backend.TaskManagement.PropriedadeModeloEquipamento;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ebc43.bc_backend.AbstractEntity.IntegerIdAbstractEntity;
import com.ebc43.bc_backend.TaskManagement.ModeloEquipamento.ModeloEquipamento;
import com.ebc43.bc_backend.TaskManagement.UnidadeMedida.UnidadeMedida;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="propriedade_modelo_equipamento")
public class PropriedadeModeloEquipamento extends IntegerIdAbstractEntity {
	@ManyToOne
	@JoinColumn(name="modelo_equipamento_id", nullable=false)
	@JsonBackReference
	private ModeloEquipamento modeloEquipamento;
	@ManyToOne
	@JoinColumn(name="unidade_medida_id", nullable=false)
	private UnidadeMedida unidadeMedida;
	@Column(name="nome", nullable=false)
	private String nome;
	@Column(name="valor", nullable=false)
	private String valor;
	
	public PropriedadeModeloEquipamento() {
	}

	public PropriedadeModeloEquipamento(Integer id, ModeloEquipamento modeloEquipamento, UnidadeMedida unidadeMedida,
			String nome, String valor, Date createdAt, Date updatedAt, Date deletedAt) {
		super(id, createdAt, updatedAt, deletedAt);
		this.modeloEquipamento = modeloEquipamento;
		this.unidadeMedida = unidadeMedida;
		this.nome = nome;
		this.valor = valor;
	}

	public ModeloEquipamento getModeloEquipamento() {
		return modeloEquipamento;
	}

	public void setModeloEquipamento(ModeloEquipamento modeloEquipamento) {
		this.modeloEquipamento = modeloEquipamento;
	}

	public UnidadeMedida getUnidadeMedida() {
		return unidadeMedida;
	}

	public void setUnidadeMedida(UnidadeMedida unidadeMedida) {
		this.unidadeMedida = unidadeMedida;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	
}
