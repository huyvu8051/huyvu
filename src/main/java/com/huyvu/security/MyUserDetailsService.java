package com.huyvu.security;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.huyvu.entity.RoleEntity;
import com.huyvu.entity.UserEntity;
import com.huyvu.repository.UserRepository;
@Service
@Transactional
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserEntity user = userRepo.findOneByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException("No user found with this email: " + email);
		}
		boolean enabled = true;
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword().toLowerCase(),
				enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, getAuthorities(user.getRoles()));
	}

	private static List<GrantedAuthority> getAuthorities(List<RoleEntity> roles) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (RoleEntity role : roles) {
			authorities.add(new SimpleGrantedAuthority(role.getCode()));
		}
		return authorities;
	}

}
