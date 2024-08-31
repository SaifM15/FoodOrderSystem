package com.foodsystem.ServiceImpl;

import java.lang.StackWalker.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodsystem.Model.IngredientCategory;
import com.foodsystem.Model.IngredientsItem;
import com.foodsystem.Model.Restaurant;
import com.foodsystem.Repository.IngredientCategoryRepository;
import com.foodsystem.Repository.IngredientItemRepository;
import com.foodsystem.Service.IngredientsService;
import com.foodsystem.Service.RestaurantService;

@Service
public class IngredientServiceImpl implements IngredientsService{
	
	@Autowired
	private	IngredientItemRepository ingredientItemRepository;
	
	@Autowired
	private IngredientCategoryRepository ingredientCategoryRepository;
	
	@Autowired
	private RestaurantService restaurantService;

	@Override
	public IngredientCategory createIngredientCategory(String name, Long restaurantId) throws Exception {
	
		Restaurant restaurant =restaurantService.findRestaurantById(restaurantId);
		
		IngredientCategory category= new IngredientCategory();
		 List<Restaurant> restaurants = new ArrayList<>();
		   restaurants.add(restaurant);
		category.setRestaurants(restaurants);
		category.setName(name);
		return ingredientCategoryRepository.save(category) ;
	}

	@Override
	public IngredientCategory findIngredientCategoryById(Long id) throws Exception {
		Optional<IngredientCategory> opt=ingredientCategoryRepository.findById(id);
		if(opt.isEmpty()) {
			throw new Exception("ingredient category not found");
		}
		return opt.get();
	}

	@Override
	public List<IngredientCategory> findIngredientCategoryByRestaurantId(Long id) throws Exception {
		restaurantService.findRestaurantById(id);
		return ingredientCategoryRepository.findByRestaurantId(id);
	}

	@Override
	public IngredientsItem createIngredienItem(Long restaurantId, String ingredientName, Long categoryId)
			throws Exception {
		Restaurant restaurant =restaurantService.findRestaurantById(restaurantId);
		IngredientCategory category= findIngredientCategoryById(categoryId);
		IngredientsItem item = new IngredientsItem();
		item.setName(ingredientName);
		item.setRestaurant(restaurant);
		item.setCategory(category);
		IngredientsItem ingredient=ingredientItemRepository.save(item);
		category.getIngredients().add(ingredient);
		
		return ingredient;
	}

	@Override
	public List<IngredientsItem> findRestaurantIngredients(Long restaurantId) {
		
		return ingredientItemRepository.findByRestaurantId(restaurantId);
	}

	@Override
	public IngredientsItem updateStock(Long id) throws Exception {
		Optional<IngredientsItem>optionalIngredientsItem=ingredientItemRepository.findById(id);
		if(optionalIngredientsItem.isEmpty()) {
			throw new Exception("Ingredients not Found");
		}
		IngredientsItem ingredientsItem=optionalIngredientsItem.get();
		ingredientsItem.setInstock(!ingredientsItem.isInstock());
		return ingredientItemRepository.save(ingredientsItem);
	}

}
