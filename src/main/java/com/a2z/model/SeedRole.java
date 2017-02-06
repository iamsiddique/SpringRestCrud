package com.a2z.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * The persistent class for the seed_roles database table.
 * 
 */
@Entity
@Table(name="seed_roles")

public class SeedRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String role;

	public SeedRole() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}