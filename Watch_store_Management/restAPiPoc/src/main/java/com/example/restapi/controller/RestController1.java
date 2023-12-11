package com.example.restapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.restapi.ent.UserDetails;
import com.example.restapi.exception.UserNotFoundException;
import com.example.restapi.service.UserService1;

@RestController
@RequestMapping("/api")
public class RestController1 {

@Autowired 	
private UserService1 userService;	


@PostMapping("/users")
public UserDetails addUser(@RequestBody UserDetails user) {
	
	user.setId(0);
	
	userService.save(user);
	
	return user;
}

@GetMapping("/g")
public List<UserDetails> findAll() {
	return userService.findAll();
}




@GetMapping("/g/{userId}")
public UserDetails getuser(@PathVariable int userId) {
	
	UserDetails user = userService.findById(userId);
	
	if (user == null) {
		throw new UserNotFoundException("user id not found - " + userId);
	}
	
	return user;
}


@PutMapping("/p")
public UserDetails updateUser(@RequestBody UserDetails user) {
	
	userService.save(user);
	
	return user;
}



@DeleteMapping("/d/{userId}")
public String deleteUser(@PathVariable int userId) { 
	
	UserDetails tempEmployee = userService.findById(userId);
	
	// throw exception if null
	
	if (tempEmployee == null) {
		throw new UserNotFoundException("user id not found - " + userId);
	}
	
	userService.deleteById(userId);
	
	return "Deleted user id - " + userId;
}
@DeleteMapping("/d")
public String deleteAllTheUsers() {
	userService.DeleteAll();

	return "Deleted All the users";
}


}
