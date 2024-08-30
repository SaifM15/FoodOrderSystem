package com.foodsystem.Service;

import java.util.List;

import com.foodsystem.Model.Category;
import com.foodsystem.Model.Food;
import com.foodsystem.Model.Restaurant;
import com.foodsystem.Request.CreateFoodRequest;

public interface FoodService {
	
	public Food createFood(CreateFoodRequest req,Category category,Restaurant restaurant);
	
	void deletefood(Long foodId) throws Exception ;
	
	public List<Food> getRestaurantFood(Long restaurantId,boolean isVegitarian,boolean isNonveg,
			boolean isSeasonal,String foodCategory);
	
	public List<Food> searchFood(String keyword);
	
	public Food findFoodById(Long foodId ) throws Exception;
	
	public Food updateAvailibilityStatus(Long foodId) throws Exception;
	
	

}
