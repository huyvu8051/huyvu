package com.huyvu.converter;

import org.springframework.stereotype.Component;

import com.huyvu.dto.RoleDTO;
import com.huyvu.entity.RoleEntity;

@Component
public class RoleConverter {
	public RoleEntity convertToEntity(RoleDTO dto) {
		RoleEntity entity = new RoleEntity();
		entity.setCode(dto.getCode());
		entity.setName(dto.getName());
		return entity;
	}

	public RoleDTO convertToDTO(RoleEntity entity) {
		RoleDTO dto = new RoleDTO();
		dto.setCode(entity.getCode());
		dto.setName(entity.getName());
		return dto;
	}
}
