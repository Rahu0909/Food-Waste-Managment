package com.boot.project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.boot.project.dao.UserRepository;
import com.boot.project.entities.Signup;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		Signup user=userRepo.findByEmail(email);
		if(user!=null) {
			return new CustomUserDetails(user);
		}
		throw new UsernameNotFoundException("User not available");
	}
	
}
