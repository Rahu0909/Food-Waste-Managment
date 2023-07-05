package com.boot.project.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.boot.project.entities.Signup;

public interface UserRepository extends JpaRepository<Signup, Long> {
	
	public boolean existsByEmail(String email);
	
	public Signup findByEmail(String email); 
}
