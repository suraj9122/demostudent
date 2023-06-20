package com.example.demo.repository;
import com.example.demo.model.UserDetails;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDetails,Integer>{

  public boolean existsByEmail(String email);
  
  
}
  