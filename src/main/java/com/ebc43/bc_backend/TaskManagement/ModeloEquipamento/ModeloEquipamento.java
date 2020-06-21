package com.ebc43.bc_backend.TaskManagement.ModeloEquipamento;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.SQLDeleteAll;
import org.hibernate.annotations.Where;

import com.ebc43.bc_backend.AbstractEntity.IntegerIdAbstractEntity;
import com.ebc43.bc_backend.TaskManagement.Marca.Marca;
import com.ebc43.bc_backend.TaskManagement.ModeloAtributoEquipamento.ModeloAtributoEquipamento;
import com.ebc43.bc_backend.TaskManagement.PropriedadeModeloEquipamento.PropriedadeModeloEquipamento;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="modelo_equipamento")
public class ModeloEquipamento extends IntegerIdAbstractEntity {
	@ManyToOne
	@JoinColumn(name="marca_id",nullable=false)
	private Marca marca;
	@Column(nullable=false)
	@Size(max=45)
	private String nome;
	@Column(name="precisa_horimetro",nullable=false)
	private Boolean precisaHorimetro;
	@OneToMany
	@JoinColumn(name="modelo_equipamento_id")
	@JsonManagedReference
	@SQLDelete(sql="update modelo_atributo_equipamento set deleted_at = now() where modelo_equipamento_id=? and id=?")
	@SQLDeleteAll(sql="update modelo_atributo_equipamento set deleted_at = now() where modelo_equipamento_id=?")
	@Where(clause="deleted_at is null")
	private List<ModeloAtributoEquipamento> modelosAtributosEquipamento;
	@OneToMany
	@JoinColumn(name="modelo_equipamento_id")
	@JsonManagedReference
	@SQLDelete(sql="update propriedade_modelo_equipamento set deleted_at = now() where modelo_equipamento_id=? and id=?")
	@SQLDeleteAll(sql="update propriedade_modelo_equipamento set deleted_at = now() where modelo_equipamento_id=?")
	@Where(clause="deleted_at is null")
	private List<PropriedadeModeloEquipamento> propriedadesModeloEquipamento;
	
	public ModeloEquipamento() {
	}

	public ModeloEquipamento(Integer id, Marca marca, @Size(max = 45) String nome,
			Boolean precisaHorimetro, List<ModeloAtributoEquipamento> modelosAtributosEquipamento,
			List<PropriedadeModeloEquipamento> propriedadesModeloEquipamento, Date createdAt, Date updatedAt,
			Date deletedAt) {
		super(id, createdAt, updatedAt, deletedAt);
		this.marca = marca;
		this.nome = nome;
		this.precisaHorimetro = precisaHorimetro;
		this.modelosAtributosEquipamento = modelosAtributosEquipamento;
		this.propriedadesModeloEquipamento = propriedadesModeloEquipamento;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Boolean getPrecisaHorimetro() {
		return precisaHorimetro;
	}

	public void setPrecisaHorimetro(Boolean precisaHorimetro) {
		this.precisaHorimetro = precisaHorimetro;
	}

	public List<ModeloAtributoEquipamento> getModelosAtributosEquipamento() {
		return modelosAtributosEquipamento;
	}

	public void setModelosAtributosEquipamento(List<ModeloAtributoEquipamento> modelosAtributosEquipamento) {
		this.modelosAtributosEquipamento = modelosAtributosEquipamento;
	}

	public List<PropriedadeModeloEquipamento> getPropriedadesModeloEquipamento() {
		return propriedadesModeloEquipamento;
	}

	public void setPropriedadesModeloEquipamento(List<PropriedadeModeloEquipamento> propriedadesModeloEquipamento) {
		this.propriedadesModeloEquipamento = propriedadesModeloEquipamento;
	}
		
}