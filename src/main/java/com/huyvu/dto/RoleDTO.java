package com.huyvu.dto;

import java.util.ArrayList;
import java.util.List;

public class RoleDTO {
	private String code;
	private String name;
	private List<UserDTO> users;

	public RoleDTO() {
		users = new ArrayList<>();

	}

	public RoleDTO(String code, String name) {
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

	public List<UserDTO> getUsers() {
		return users;
	}

	public void setUsers(List<UserDTO> users) {
		this.users = users;
	}

}
