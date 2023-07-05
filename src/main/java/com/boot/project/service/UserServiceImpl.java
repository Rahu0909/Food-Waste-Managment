package com.boot.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.boot.project.dao.UserRepository;
import com.boot.project.entities.Signup;

@Component
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public Signup createUser(Signup user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole("Role_USER");
		return userRepo.save(user);
	}

	@Override
	public boolean checkEmail(String email) {
		return userRepo.existsByEmail(email);
	}

}
