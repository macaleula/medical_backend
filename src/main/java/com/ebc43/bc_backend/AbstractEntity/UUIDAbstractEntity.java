package com.ebc43.bc_backend.AbstractEntity;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;


@MappedSuperclass
public class UUIDAbstractEntity extends AbstractEntity {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id", updatable = false, nullable = false)
	private UUID id;

	public UUIDAbstractEntity() {
		super();
	}

	public UUIDAbstractEntity(UUID id, Date createdAt, Date updatedAt, Date deletedAt) {
		super(createdAt, updatedAt, deletedAt);
		this.id = id;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
}
