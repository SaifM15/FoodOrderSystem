package com.foodsystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodsystem.Model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

	public Cart findByCustomerId(Long id);

	
}
