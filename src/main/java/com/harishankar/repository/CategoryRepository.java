package com.harishankar.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.harishankar.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

}
