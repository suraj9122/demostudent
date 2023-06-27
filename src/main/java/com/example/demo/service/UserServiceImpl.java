package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Course;
import com.example.demo.model.UserDetails;
import com.example.demo.repository.CourseRepo;
import com.example.demo.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;
	@Autowired
	private CourseRepo crepo;
	@Override
	public UserDetails createUser(UserDetails user) {
		// TODO Auto-generated method stub
		return userRepo.save(user);
	}
	@Override
	public boolean checkEmail(String email) {
		// TODO Auto-generated method stub
		return userRepo.existsByEmail(email);
	}
	@Override
	public UserDetails fetchuser(Integer id) {
		// TODO Auto-generated method stub
		return userRepo.getById(id);
	}
	@Override
	public Boolean Update(UserDetails user) {
		userRepo.save(user);
		return true;
	}
	
	


}
