package com.example.heroku.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.heroku.model.Grocery;

@Repository
public interface GroceryRepository extends JpaRepository<Grocery, Integer>{
	
}
