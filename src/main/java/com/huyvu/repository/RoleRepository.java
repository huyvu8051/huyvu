package com.huyvu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.huyvu.entity.RoleEntity;

public interface RoleRepository extends JpaRepository<RoleEntity, Long>{
	
}
