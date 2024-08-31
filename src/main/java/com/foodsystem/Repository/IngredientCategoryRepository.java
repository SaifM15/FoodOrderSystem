package com.foodsystem.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodsystem.Model.IngredientCategory;

public interface IngredientCategoryRepository extends JpaRepository<IngredientCategory, Long>{
	
	List<IngredientCategory> findByRestaurantId(Long id);
	
	
	
}	
