package com.foodsystem.Service;

import com.foodsystem.Model.User;

public interface UserService {
	
	public User findUserByJwtToken(String jwt) throws Exception;
	
	public User findUserByEmail(String email) throws Exception;

}
