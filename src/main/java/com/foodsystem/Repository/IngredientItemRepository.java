package com.foodsystem.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodsystem.Model.IngredientsItem;

public interface IngredientItemRepository extends JpaRepository<IngredientsItem, Long>{
	
	List<IngredientsItem>findByRestaurantId(Long id);
	
	

}
