package com.example.restapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restapi.ent.UserDetails;
import com.example.restapi.exception.UserNotFoundException;
import com.example.restapi.repo.UserRepository;
import com.example.restapi.repo.WatchRepository;
@Service
public class UserServiceimpl implements UserService1 {
	
	
	
@Autowired	
private  UserRepository userRepository;
@Autowired
private WatchRepository watchRepository;


   @Override
	public List<UserDetails> findAll() {
	
		return  userRepository.findAll();
	}

	@Override
	public UserDetails findById(int theId) {
	
Optional<UserDetails> result =userRepository.findById(theId);
		
          UserDetails user = null;
		
		if (result.isPresent()) {
			user = result.get();
		}
		else {
		
			throw new UserNotFoundException("Did not find user id - " + theId);
		}
		
		return user;
	}
	

	@Override
	public void save(UserDetails user) {
		userRepository.save(user);

	}

	@Override
	public void deleteById(int theId) {
	     userRepository.deleteById(theId);

	}


		
	

	@Override
	public void DeleteAll() {
		// TODO Auto-generated method stub
		userRepository.deleteAll();
	}

}
