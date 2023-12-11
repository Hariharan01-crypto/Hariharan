package com.example.Book_Store_Management.BookStoreController;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.Book_Store_Management.BookStoreEntity.UserEntity;
import com.example.Book_Store_Management.BookStoreRepository.BookStore_Repository;
import com.example.Book_Store_Management.BookStoreService.BookStore_Service;
import com.example.Book_Store_Management.Exceptiono.ClassNotFound;
import com.example.Book_Store_Management.Exceptiono.UpdateIdNotFound;

import jakarta.validation.Valid;

@RestController
public class BookStore_Controller {
	
	@Autowired
	BookStore_Service service;
	
	@Autowired
	BookStore_Repository repoo;
	
	@PostMapping("/p")
	ResponseEntity<UserEntity> posto(@RequestBody @Valid  UserEntity u) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.posto(u));
	}
	
	@GetMapping("/g")
	List<UserEntity> geto(){
		return service.geto();
	}
	
	@DeleteMapping("/d/{id}")
	String DeleteById(@Valid  @PathVariable("id") Long UserId) throws ClassNotFound {
		 service.DeleteById(UserId);
		 return "the user: "+UserId+" has been deleted";
	}
	
	@DeleteMapping("/dd")
	String DeleteAll() {
		service.DeleteAll();
		return "Every data has been deleted";
	}
	
	@PutMapping("/p/{id}")
	UserEntity updato(@Valid @PathVariable("id") Long UserId,@RequestBody UserEntity u2) throws UpdateIdNotFound {
		return service.updato(UserId,u2);
	}
	
	 @GetMapping("/g1")
	 public ModelAndView get1(){
		ModelAndView mav=new ModelAndView("users");
		List<UserEntity> list=repoo.findAll();
		mav.addObject("users",list);
		return mav;
	}
	 
	
	 @GetMapping("/g/{id}")
	 Optional<UserEntity> getUserByid(@PathVariable("id") Long id) {
		 
		return service.getUserByid(id);
	 }
	 
}
