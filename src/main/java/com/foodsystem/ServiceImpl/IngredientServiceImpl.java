package com.foodsystem.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodsystem.Model.IngredientCategory;
import com.foodsystem.Model.IngredientsItem;
import com.foodsystem.Repository.IngredientCategoryRepository;
import com.foodsystem.Repository.IngredientItemRepository;
import com.foodsystem.Service.IngredientsService;

@Service
public class IngredientServiceImpl implements IngredientsService{
	
	@Autowired
	private	IngredientItemRepository ingredientItemRepository;
	
	@Autowired
	private IngredientCategoryRepository ingredientCategoryRepository;

	@Override
	public IngredientCategory createIngredientCategory(String name, Long restaurantId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IngredientCategory findIngredientCategory(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IngredientCategory> findIngredientCategoryByRestaurantId(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IngredientsItem createIngredienItem(Long restaurantId, String ingredientName, Long categoryId)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<IngredientsItem> findRestaurantIngredients(Long restaurantId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IngredientsItem updateStock(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
