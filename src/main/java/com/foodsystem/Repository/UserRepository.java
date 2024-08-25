package com.foodsystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodsystem.Model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	public User findByEmail(String username);
	
	

}
