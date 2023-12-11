package com.example.restapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.restapi.ent.WatchDetails;


@Repository
public interface WatchRepository extends JpaRepository<WatchDetails,Integer>{

	
	
}
