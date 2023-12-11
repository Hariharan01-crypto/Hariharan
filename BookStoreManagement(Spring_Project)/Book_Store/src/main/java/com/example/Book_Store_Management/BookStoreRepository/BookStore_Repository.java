package com.example.Book_Store_Management.BookStoreRepository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Book_Store_Management.BookStoreEntity.UserEntity;

@Repository
public interface BookStore_Repository extends JpaRepository<UserEntity, Long> {

}
