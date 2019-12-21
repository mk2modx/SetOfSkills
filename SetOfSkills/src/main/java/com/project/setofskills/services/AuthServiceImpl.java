package com.project.setofskills.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.setofskills.entities.User;
import com.project.setofskills.repositories.UserRepository;

@Service
public class AuthServiceImpl implements AuthService {

	@Autowired
	UserRepository userrepo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	
	@Override
	public User register(User user) {
		// encrypt and set the password for the user
			String encryptedPassword = encoder.encode(user.getPassword());
			user.setPassword(encryptedPassword);
			//business decision to set enabled
			user.setEnabled(true);
		// set role field to standard
			user.setRole("ADMIN");
			
			userrepo.saveAndFlush(user);
			
		return user;
	}

	
}
