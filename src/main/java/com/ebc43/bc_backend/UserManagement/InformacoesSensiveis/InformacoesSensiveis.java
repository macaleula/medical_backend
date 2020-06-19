package com.ebc43.bc_backend.UserManagement.InformacoesSensiveis;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.ebc43.bc_backend.AbstractEntity.IntegerIdAbstractEntity;


@Entity
@Table(name="informacoes_sensiveis")
public class InformacoesSensiveis extends IntegerIdAbstractEntity {
	@Column(nullable = false)
	@Size(max=45)
	private String username;
	@Column(nullable = false)
	@Size(max=255)
	private String email;
	@Column(nullable = false)
	@Size(max=60)
	private String password;
	
	public InformacoesSensiveis() {
	}

	public InformacoesSensiveis(Integer id, @Size(max = 45) String username, @Size(max = 255) String email,
			@Size(max = 60) String password, Date createdAt, Date updatedAt, Date deletedAt) {
		super(id, createdAt, updatedAt, deletedAt);
		this.username = username;
		this.email = email;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
	