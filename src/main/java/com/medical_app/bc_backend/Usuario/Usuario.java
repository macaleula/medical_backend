package com.medical_app.bc_backend.Usuario;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.medical_app.bc_backend.AbstractEntity.EntidadeAbstrata;
import com.medical_app.bc_backend.TipoUsuario.TipoUsuario;

@Entity
@Table(name="usuario")
public class Usuario extends EntidadeAbstrata {
	@ManyToOne
	@JoinColumn(name="tipo_usuario_id")
	private TipoUsuario tipoUsuario;
	@Column(nullable = false)
	private String username;
	@Column(nullable = false)
	@JsonProperty(access = Access.WRITE_ONLY)	
	private String password;
	@Column(nullable = false)
	private String nome;
	
	public Usuario() {
		super();
	}

	public Usuario(Integer id, TipoUsuario tipoUsuario, String username, String password, String nome) {
		super(id);
		this.tipoUsuario = tipoUsuario;
		this.username = username;
		this.password = password;
		this.nome = nome;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
