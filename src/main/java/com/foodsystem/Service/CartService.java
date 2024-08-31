package com.foodsystem.Service;

import com.foodsystem.Model.CartItem;
import com.foodsystem.Request.AddCartItemRequest;

public interface CartService {

	public CartItem addItemToCart(AddCartItemRequest req,String jwt)throws Exception;
}
