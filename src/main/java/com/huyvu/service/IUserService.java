package com.huyvu.service;

import com.huyvu.dto.UserDTO;
import com.huyvu.entity.UserEntity;
import com.huyvu.entity.VerificationToken;
import com.huyvu.exception.UserAlreadyExistException;

public interface IUserService {
	UserDTO registerNewUserAccount(UserDTO userDTO) throws UserAlreadyExistException;

	String createVerificationToken(UserDTO user, String token);

	VerificationToken getVerificationToken(String token);

	void saveRegisteredUser(UserEntity user);
}
