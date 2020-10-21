package com.medical_app.bc_backend.AbstractEntity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class EntidadeAbstrata {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Integer id;

	public EntidadeAbstrata() {
	}

	public EntidadeAbstrata(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
