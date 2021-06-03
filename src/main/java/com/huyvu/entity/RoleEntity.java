package com.huyvu.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class RoleEntity {
	@Id
	@Column(name = "code")
	private String code;
	@Column(name = "name")
	private String name;

	@ManyToMany(mappedBy = "roles")
	private List<UserEntity> users;

	public RoleEntity() {
		users = new ArrayList<>();
	}

	public RoleEntity(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
