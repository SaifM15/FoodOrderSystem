package com.foodsystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodsystem.Model.IngredientsItem;

public interface IngredientItemRepository extends JpaRepository<IngredientsItem, Long>{
	
	

}
