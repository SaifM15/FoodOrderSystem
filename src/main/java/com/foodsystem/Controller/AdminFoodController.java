package com.foodsystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foodsystem.Model.Food;
import com.foodsystem.Model.Restaurant;
import com.foodsystem.Model.User;
import com.foodsystem.Request.CreateFoodRequest;
import com.foodsystem.Response.MessageResponse;
import com.foodsystem.Service.FoodService;
import com.foodsystem.Service.RestaurantService;
import com.foodsystem.Service.UserService;

@RestController
@RequestMapping("/api/admin/food")
public class AdminFoodController {
	
	@Autowired
	private FoodService foodService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RestaurantService restaurantService;
	
	@PostMapping()
	public ResponseEntity<Food>createFood(@RequestBody CreateFoodRequest req,
						@RequestHeader("Authorization")String jwt) throws Exception{
		User user=userService.findUserByJwtToken(jwt);
		Restaurant restaurant=restaurantService.findRestaurantById(req.getRestaurantId());
		Food food =foodService.createFood(req, req.getCategory(), restaurant);
		
		return new ResponseEntity<>(food,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<MessageResponse>deleteFood(@PathVariable Long id,
						@RequestHeader("Authorization")String jwt) throws Exception{
		User user=userService.findUserByJwtToken(jwt);
	
		foodService.deletefood(id);
		
		MessageResponse response=new MessageResponse();
		response.setMessage("Food Delete Successfully....!");
		
		return new ResponseEntity<>(response,HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Food>updateFoodAvaibityStatus(@PathVariable Long id,
						@RequestHeader("Authorization")String jwt) throws Exception{
		User user=userService.findUserByJwtToken(jwt);
	
		Food food=foodService.updateAvailibilityStatus(id);
		
		return new ResponseEntity<>(food,HttpStatus.CREATED);
	}
	
	
	
	
}
