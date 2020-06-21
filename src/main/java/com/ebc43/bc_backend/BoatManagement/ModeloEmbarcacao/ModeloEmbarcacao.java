package com.ebc43.bc_backend.BoatManagement.ModeloEmbarcacao;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.ebc43.bc_backend.AbstractEntity.IntegerIdAbstractEntity;
import com.ebc43.bc_backend.TaskManagement.Marca.Marca;

@Entity
@Table(name="modelo_embarcacao")
public class ModeloEmbarcacao extends IntegerIdAbstractEntity {
	@ManyToOne
	@JoinColumn(name="marca_id",nullable=false)
	private Marca marca;
	@Column(nullable = false)
	@Size(max=45)
	private String modelo;
	@Column(nullable = false)
	private Integer tamanho_pes;
	
	public ModeloEmbarcacao() {
		super();
	}

	public ModeloEmbarcacao(Integer id, Marca marca, @Size(max = 45) String modelo,
			Integer tamanho_pes, Date createdAt, Date updatedAt, Date deletedAt) {
		super(id, createdAt, updatedAt, deletedAt);
		this.marca = marca;
		this.modelo = modelo;
		this.tamanho_pes = tamanho_pes;
	}
	
	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Integer getTamanho_pes() {
		return tamanho_pes;
	}

	public void setTamanho_pes(Integer tamanho_pes) {
		this.tamanho_pes = tamanho_pes;
	}
	
}