package com.huyvu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.huyvu.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
	UserEntity findOneByEmail(String email);
}
