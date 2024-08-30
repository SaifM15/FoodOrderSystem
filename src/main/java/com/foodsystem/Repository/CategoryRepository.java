package com.foodsystem.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodsystem.Model.Category;

public interface CategoryRepository extends JpaRepository<Category ,Long> {
	
	public List<Category>findByRestaurantId(Long id);
}
