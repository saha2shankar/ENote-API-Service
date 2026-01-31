package com.harishankar.service;

import java.util.List;

import com.harishankar.entity.Category;

public interface CategoryService {

	public Boolean  saveCategory(Category category);
	public List<Category> getAllCotegory();
	
}
