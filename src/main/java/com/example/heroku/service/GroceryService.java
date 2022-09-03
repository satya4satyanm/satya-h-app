package com.example.heroku.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.heroku.model.Grocery;
import com.example.heroku.repository.GroceryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GroceryService {
	private final GroceryRepository groceryRepository;
	
	@Transactional
	public Grocery saveGrocery(Grocery grocery) {
		return groceryRepository.save(grocery);
	}
	
	@Transactional
	public List<Grocery> findAllGrocery() {
		return groceryRepository.findAll();
	}
}
