package com.ebc43.bc_backend.AbstractEntity;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class IntegerIdAbstractEntity extends AbstractEntity {
	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE) 
	private Integer id;

	public IntegerIdAbstractEntity() {
		super();
	}

	public IntegerIdAbstractEntity(Integer id, Date createdAt, Date updatedAt, Date deleted) {
		super(createdAt, updatedAt, deleted);
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
