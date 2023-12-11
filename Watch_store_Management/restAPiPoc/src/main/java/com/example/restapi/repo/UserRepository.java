package com.example.restapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restapi.ent.UserDetails;


@Repository
public interface UserRepository extends JpaRepository<UserDetails,Integer> {

	

}
