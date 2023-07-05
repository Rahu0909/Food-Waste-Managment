package com.boot.project.service;

import com.boot.project.entities.Signup;


public interface UserService {

	public Signup createUser(Signup user);
	public boolean checkEmail(String email);
}
