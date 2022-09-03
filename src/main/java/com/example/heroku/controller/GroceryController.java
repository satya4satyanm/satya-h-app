package com.example.heroku.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.heroku.model.Grocery;
import com.example.heroku.service.GroceryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class GroceryController {
	
	@Value("${spring.application.name}")
    String appName;
	
	private final GroceryService groceryService;
	
	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping("/")
    public ModelAndView homePage(ModelAndView modelView, Model model) {
		
		List<Grocery> gl = groceryService.findAllGrocery();
		
        model.addAttribute("appName", appName);
        model.addAttribute("gl", gl);
		modelView.setViewName("index");
        return modelView;
    }
	
	@CrossOrigin(origins = "http://localhost:8080")
	@PostMapping("/grocery")
	public Grocery saveGrocery(@RequestBody Grocery grocery) {
		return groceryService.saveGrocery(grocery);
	}
	
}
