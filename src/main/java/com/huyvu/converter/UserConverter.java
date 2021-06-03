package com.huyvu.converter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.huyvu.dto.RoleDTO;
import com.huyvu.dto.UserDTO;
import com.huyvu.entity.RoleEntity;
import com.huyvu.entity.UserEntity;

@Component
public class UserConverter {
	@Autowired
	private RoleConverter roleConv;

	public UserDTO convertToDto(UserEntity entity) {
		UserDTO dto = new UserDTO();
		dto.setId(entity.getId());
		dto.setFirstName(entity.getFirstName());
		dto.setLastName(entity.getLastName());
		dto.setPassword(entity.getPassword());
		dto.setEmail(entity.getEmail());
		dto.setEnable(entity.isEnabled());
		return dto;
	}

	public UserEntity convertToEntity(UserDTO dto) {
		UserEntity entity = new UserEntity();
		entity.setFirstName(dto.getFirstName());
		entity.setLastName(dto.getLastName());
		entity.setPassword(dto.getPassword());
		entity.setEmail(dto.getEmail());
		entity.setEnabled(dto.isEnable());

		List<RoleEntity> roles = new ArrayList<>();
		for (RoleDTO item : dto.getRoles()) {
			roles.add(roleConv.convertToEntity(item));
		}
		entity.setRoles(roles);

		return entity;
	}
}
