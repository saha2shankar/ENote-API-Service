package com.harishankar.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.CollectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.harishankar.entity.Category;
import com.harishankar.service.CategoryService;

@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/save-category")
	public ResponseEntity<?> saveCategory(@RequestBody Category category){
		Boolean saveCategory = categoryService.saveCategory(category);
		if(saveCategory) {
			return new ResponseEntity<>("saved success !",HttpStatus.CREATED);
		}
		return new ResponseEntity<>("failed !",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/category")
	private ResponseEntity<?> getAllCategory(){
		List<Category> allCotegory = categoryService.getAllCotegory();
		if(org.springframework.util.CollectionUtils.isEmpty(allCotegory)) {
			return ResponseEntity.noContent().build();
		}
		return new ResponseEntity<>(allCotegory, HttpStatus.OK);
	}
}
