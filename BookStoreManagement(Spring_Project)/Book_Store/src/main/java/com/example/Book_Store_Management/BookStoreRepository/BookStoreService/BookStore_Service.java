package com.example.Book_Store_Management.BookStoreService;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Book_Store_Management.BookStoreEntity.BookEntity;
import com.example.Book_Store_Management.BookStoreEntity.UserEntity;
import com.example.Book_Store_Management.BookStoreRepository.BookStore_Repository;
import com.example.Book_Store_Management.Exceptiono.ClassNotFound;
import com.example.Book_Store_Management.Exceptiono.UpdateIdNotFound;

@Service
public class BookStore_Service {
	
	@Autowired
	BookStore_Repository repo;

	public UserEntity posto(UserEntity u) {
		// TODO Auto-generated method stub
		return repo.save(u);
	}

	public List<UserEntity> geto() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	

	public void DeleteAll() {
		// TODO Auto-generated method stub
		repo.deleteAll();
	}

	

	public UserEntity updato(Long userId, UserEntity u2) throws UpdateIdNotFound {
		// TODO Auto-generated method stub
		if(repo.findById(userId).isPresent()) {
		UserEntity db = repo.findById(userId).get();
		if(Objects.nonNull(u2.getUserName()) && !"".equalsIgnoreCase(u2.getUserName())) {
			db.setUserName(u2.getUserName());
		}
		if(Objects.nonNull(u2.getUserEmail()) && !"".equalsIgnoreCase(u2.getUserEmail())) {
			db.setUserEmail(u2.getUserEmail());
		}
		if(Objects.nonNull(u2.getUserPhoneNo()) && !"".equalsIgnoreCase(u2.getUserPhoneNo())) {
			db.setUserPhoneNo(u2.getUserPhoneNo());
		}
		/*
		 * if(Objects.nonNull(u2.getBook()) && !"".equalsIgnoreCase(u2.getBook())) {
		 * db.setUserPhoneNo(u2.getUserPhoneNo()); }
		 * if(Objects.nonNull(u2.getBook().get(0).getBookGenre()) &&
		 * !"".equalsIgnoreCase(u2.getBook().get(0).getBookGenre())) {
		 * db.setUserPhoneNo(u2.getUserPhoneNo()); }
		 * if(Objects.nonNull(u2.getBook().get(0).getBookName()) &&
		 * !"".equalsIgnoreCase(u2.getBook().get(0).getBookName())) {
		 * db.setUserPhoneNo(u2.getUserPhoneNo()); }
		 */
		BookEntity obj=new BookEntity();
		obj.setBookCost(u2.getBook().get(0).getBookCost());
		obj.setBookGenre(u2.getBook().get(0).getBookGenre());
		obj.setBookName(u2.getBook().get(0).getBookName());
		
		List<BookEntity> objj=u2.getBook();
		objj.add(obj);
		UserEntity build = UserEntity.builder().UserId(userId).UserEmail(u2.getUserEmail()).UserName(u2.getUserName()).UserPhoneNo(u2.getUserPhoneNo()).book(objj).build();
		return repo.save(build);
		}
		else {
			throw new UpdateIdNotFound("UPDATE NOT FOUND");
		}
	}

	public void DeleteById(Long userId) throws ClassNotFound {
		// TODO Auto-generated method stub
		
		 if(repo.findById(userId).isPresent()) {
			 repo.deleteById(userId);
		 }
		 else {
			 throw new ClassNotFound("the id which you want delete is not exist...");
		 }

	}

	public Optional<UserEntity> getUserByid(Long id) {
		// TODO Auto-generated method stub
		return repo.findById(id);
	}
	
	
	
	
}
