package com.medical_app.bc_backend.TipoUsuario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.medical_app.bc_backend.AbstractEntity.EntidadeAbstrata;

@Entity
@Table(name="tipo_usuario")
public class TipoUsuario extends EntidadeAbstrata {
	@Column(nullable = false)
	@Size(max=45)
	private String nome;
	
	public TipoUsuario() {
	}

	public TipoUsuario(Integer id, @Size(max = 45) String nome) {
		super(id);
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}