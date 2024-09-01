package com.foodsystem.Request;

import java.util.List;

public class AddCartItemRequest {

	private Long foodId;

	private int quantity;

	private List<String> ingredients;
	
	

	public AddCartItemRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddCartItemRequest(Long foodId, int quantity, List<String> ingredients) {
		super();
		this.foodId = foodId;
		this.quantity = quantity;
		this.ingredients = ingredients;
	}

	@Override
	public String toString() {
		return "AddCartItemRequest [foodId=" + foodId + ", quantity=" + quantity + ", ingredients=" + ingredients + "]";
	}

	public Long getFoodId() {
		return foodId;
	}

	public void setFoodId(Long foodId) {
		this.foodId = foodId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public List<String> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<String> ingredients) {
		this.ingredients = ingredients;
	}

}
