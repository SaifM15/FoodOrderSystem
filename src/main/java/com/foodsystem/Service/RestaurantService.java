package com.foodsystem.Service;

import java.util.List;

import com.foodsystem.Model.Restaurant;
import com.foodsystem.Model.User;
import com.foodsystem.Request.CreateRestaurantRequest;
import com.foodsystem.dto.RestaurantDto;


public interface RestaurantService {
	
	public Restaurant createRestaurant(CreateRestaurantRequest req,User user);
	
	public Restaurant updateRestaurant(Long restaurantId,CreateRestaurantRequest updatedRestaurant)throws Exception;

	public void deleteRestaurant(Long restaurantId) throws Exception;
	
	public List<Restaurant>getAllRestaurant();
	
	public List<Restaurant>searchRestaurant(String keyword);
	
	public Restaurant findRestaurantById(Long id) throws Exception;
	
	public Restaurant getRestaurantByUserId(Long id)throws Exception;

	public RestaurantDto addToFavorites(Long restaurantId,User user) throws Exception;
	
	public Restaurant updateRestaurantStatus(Long id)throws Exception;
}
