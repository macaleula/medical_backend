package com.ebc43.bc_backend.UserManagement.Usuario;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.ebc43.bc_backend.AbstractEntity.IntegerIdAbstractEntity;
import com.ebc43.bc_backend.UserManagement.InformacoesSensiveis.InformacoesSensiveis;
import com.ebc43.bc_backend.UserManagement.TipoUsuario.TipoUsuario;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="usuario")
public class Usuario extends IntegerIdAbstractEntity {
	@ManyToOne
	@JoinColumn(name="tipo_usuario_id")
	private TipoUsuario tipo;
	@ManyToOne
	@JoinColumn(name="informacoes_sensiveis_id")
	@JsonIgnore
	private InformacoesSensiveis informacoesSensiveis;
	@Column(nullable = false)
	private Boolean admin;
	@Column(nullable = false)
	@Size(max=45)
	private String sigla;
	@Column(nullable = false)
	@Size(max=45)
	private String nome;
	@Column(name="LastSyncTime")
	private Date lastSyncTime;
	
	public Usuario() {
		super();
	}

	public Usuario(Integer id, TipoUsuario tipo, InformacoesSensiveis informacoesSensiveis, Boolean admin,
			@Size(max = 45) String sigla, @Size(max = 45) String nome, Date createdAt, Date updatedAt,
			Date lastSyncTime, Date deletedAt) {
		super(id, createdAt, updatedAt, deletedAt);
		this.tipo = tipo;
		this.informacoesSensiveis = informacoesSensiveis;
		this.admin = admin;
		this.sigla = sigla;
		this.nome = nome;
		this.lastSyncTime = lastSyncTime;
	}

	public TipoUsuario getTipo() {
		return tipo;
	}

	public void setTipo(TipoUsuario tipo) {
		this.tipo = tipo;
	}

	public InformacoesSensiveis getInformacoesSensiveis() {
		return informacoesSensiveis;
	}

	public void setInformacoesSensiveis(InformacoesSensiveis informacoesSensiveis) {
		this.informacoesSensiveis = informacoesSensiveis;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getNome() {
		return nome;
	}

	public Date getLastSyncTime() {
		return lastSyncTime;
	}

	public void setLastSyncTime(Date lastSyncTime) {
		this.lastSyncTime = lastSyncTime;
	}
	
}
