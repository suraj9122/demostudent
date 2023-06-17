package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.UserDetails;
import com.example.demo.repository.UserRepository;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	@Override
	public UserDetails createUser(UserDetails user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
	}

}
