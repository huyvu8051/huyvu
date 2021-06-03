package com.huyvu.service.impl;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huyvu.converter.UserConverter;
import com.huyvu.dto.RoleDTO;
import com.huyvu.dto.UserDTO;
import com.huyvu.entity.UserEntity;
import com.huyvu.entity.VerificationToken;
import com.huyvu.exception.UserAlreadyExistException;
import com.huyvu.repository.UserRepository;
import com.huyvu.service.IUserService;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private UserConverter userConv;

	@Override
	public UserDTO registerNewUserAccount(UserDTO userDTO) throws UserAlreadyExistException {
		if (emailExist(userDTO.getEmail()))
			throw new UserAlreadyExistException("There is an account with that email address :" + userDTO.getEmail());

		userDTO.setRoles(Arrays.asList(new RoleDTO("USER", "user")));
		UserEntity entity = userRepo.save(userConv.convertToEntity(userDTO));
		return userConv.convertToDto(entity);
	}

	private boolean emailExist(String email) {
		return userRepo.findOneByEmail(email) != null;
	}

	@Override
	public String createVerificationToken(UserDTO user, String token) {
		return null;
	}

	@Override
	public VerificationToken getVerificationToken(String token) {
		return null;
	}

	@Override
	public void saveRegisteredUser(UserEntity user) {
		// TODO Auto-generated method stub
		
	}

}