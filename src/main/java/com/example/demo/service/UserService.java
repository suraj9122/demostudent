package com.example.demo.service;

import com.example.demo.model.UserDetails;

public interface UserService  {
	public UserDetails createUser(UserDetails users);

public boolean checkEmail(String email);
UserDetails fetchuser(Integer id);

public Boolean Update(UserDetails user);

}