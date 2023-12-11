package com.example.restapi.service;

import java.util.List;
import java.util.Set;

import com.example.restapi.ent.UserDetails;

public interface UserService1 {

		public List<UserDetails> findAll();
		
		public UserDetails findById(int theId);
		
		public void save(UserDetails user);
		
		public void deleteById(int theId);
		
		public void DeleteAll();
		
	}




