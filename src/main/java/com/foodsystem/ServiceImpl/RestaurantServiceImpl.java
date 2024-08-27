package com.foodsystem.ServiceImpl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodsystem.Model.Address;
import com.foodsystem.Model.Restaurant;
import com.foodsystem.Model.User;
import com.foodsystem.Repository.AddressRepository;
import com.foodsystem.Repository.RestaurantRepository;
import com.foodsystem.Repository.UserRepository;
import com.foodsystem.Request.CreateRestaurantRequest;
import com.foodsystem.Service.RestaurantService;
import com.foodsystem.dto.RestaurantDto;

@Service
public class RestaurantServiceImpl implements RestaurantService{
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public Restaurant createRestaurant(CreateRestaurantRequest req, User user) {
		
		Address address=addressRepository.save(req.getAddress());
		Restaurant restaurant=new Restaurant();
		restaurant.setAddress(address);
		restaurant.setContactInformation(req.getContactInformation());
		restaurant.setCuisineType(req.getCuisineType());
		restaurant.setDescription(req.getDescription());
		restaurant.setImages(req.getImages());
		restaurant.setName(req.getName());
		restaurant.setOpeningHours(req.getOpeningHours());
		restaurant.setRegistrationDate(LocalDateTime.now());
		restaurant.setOwner(user);
		return restaurantRepository.save(restaurant);
	}

	@Override
	public Restaurant updateRestaurant(Long restaurantId, CreateRestaurantRequest updatedRestaurant) throws Exception {
		Restaurant restaurant=findRestaurantById(restaurantId);
		if(restaurant.getCuisineType()!=null) {
			restaurant.setCuisineType(updatedRestaurant.getCuisineType());
		}
		if(restaurant.getDescription()!=null) {
			restaurant.setDescription(updatedRestaurant.getDescription());
		}
		if(restaurant.getName()!=null) {
			restaurant.setName(updatedRestaurant.getName());
		}
		return restaurantRepository.save(restaurant);
	}

	@Override
	public void deleteRestaurant(Long restaurantId) throws Exception {
		
		Restaurant restaurant= findRestaurantById(restaurantId);
		restaurantRepository.delete(restaurant);
		
	}

	@Override
	public List<Restaurant> getAllRestaurant() {		
		return restaurantRepository.findAll();
	}

	@Override
	public List<Restaurant> searchRestaurant(String keyword) {
		
		return restaurantRepository.findBySearchQuery(keyword);
	}

	@Override
	public Restaurant findRestaurantById(Long id) throws Exception {
		
		Optional<Restaurant> opt=restaurantRepository.findById(id);
		if(opt.isEmpty()) {
			throw new Exception("Restaurant not found with id" + id);
		}
		return opt.get();
	}

	@Override
	public Restaurant getRestaurantByUserId(Long id) throws Exception {
		
		Restaurant restaurant=restaurantRepository.finbyOwnerId(id);
		if(restaurant==null) {
			throw new Exception("restaurant not found with owner id" + id);
		}
		return restaurant;
	}

	@Override
	public RestaurantDto addToFavorites(Long restaurantId, User user) throws Exception {
		
		Restaurant restaurant=findRestaurantById(restaurantId);
		RestaurantDto dto=new RestaurantDto();
		dto.setDescription(restaurant.getDescription());
		dto.setImages(restaurant.getImages());
		dto.setTitle(restaurant.getName());
		dto.setId(restaurantId);
		
		if(user.getFavorites().contains(dto)) {
			user.getFavorites().remove(dto);
		}else {
			user.getFavorites().add(dto);
			
		}
		userRepository.save(user);
		return dto;
	}

	@Override
	public Restaurant updateRestaurantStatus(Long id) throws Exception {
		Restaurant restaurant=findRestaurantById(id);
		restaurant.setOpen(!restaurant.isOpen());
		return restaurantRepository.save(restaurant);
	}

}
