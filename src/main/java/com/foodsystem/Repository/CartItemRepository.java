package com.foodsystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodsystem.Model.Cart;
import com.foodsystem.Model.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long>{
	
	public Cart findByCustomerId(Long userId);
	
	

}
