package com.foodsystem.ServiceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodsystem.Model.Cart;
import com.foodsystem.Model.CartItem;
import com.foodsystem.Model.Food;
import com.foodsystem.Model.User;
import com.foodsystem.Repository.CartItemRepository;
import com.foodsystem.Repository.CartRepository;
import com.foodsystem.Repository.FoodRepository;
import com.foodsystem.Request.AddCartItemRequest;
import com.foodsystem.Service.CartService;
import com.foodsystem.Service.FoodService;
import com.foodsystem.Service.UserService;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private CartItemRepository cartItemRepository;

	@Autowired
	private FoodService foodService;

	@Override
	public CartItem addItemToCart(AddCartItemRequest req, String jwt) throws Exception {

		User user = userService.findUserByJwtToken(jwt);

		Food food = foodService.findFoodById(req.getFoodId());

		Cart cart = cartRepository.findByCustomerId(user.getId());

		for (CartItem cartItem : cart.getItem()) {

			if (cartItem.getFood().equals(food)) {
				int newQuantity = cartItem.getQuantity() + req.getQuantity();
				return updateCartItemQuantity(cartItem.getId(), newQuantity);
			}

		}

		CartItem newCartItem = new CartItem();
		newCartItem.setFood(food);
		newCartItem.setCart(cart);
		newCartItem.setQuantity(req.getQuantity());
		newCartItem.setIngredients(req.getIngredients());
		newCartItem.setTotalPrice(req.getQuantity() * food.getPrice());

		CartItem savedCartItem = cartItemRepository.save(newCartItem);

		cart.getItem().add(savedCartItem);

		return savedCartItem;
	}

	@Override
	public CartItem updateCartItemQuantity(Long cartItemId, int quanity) throws Exception {

		Optional<CartItem> cartItemOptional = cartItemRepository.findById(cartItemId);
		if (cartItemOptional.isEmpty()) {
			throw new Exception("Cart item not found");
		}
		CartItem item = cartItemOptional.get();
		item.setQuantity(quanity);
//		5*100=5000
		item.setTotalPrice((item.getFood().getPrice() * quanity));
		return cartItemRepository.save(item);
	}

	@Override
	public Cart removeItemFromCart(Long cartItemId, String jwt) throws Exception {

		User user = userService.findUserByJwtToken(jwt);

		Cart cart = cartRepository.findByCustomerId(user.getId());

		Optional<CartItem> cartItemOptional = cartItemRepository.findById(cartItemId);
		if (cartItemOptional.isEmpty()) {
			throw new Exception("Cart item not found");
		}
		CartItem item = cartItemOptional.get();
		cart.getItem().remove(item);
		
		return cartRepository.save(cart);
	}

	@Override
	public Long calculateCartTotals(Cart cart) throws Exception {
	
		Long total=0L;
		
		for(CartItem cartItem :cart.getItem()) {
			total+=cartItem.getFood().getPrice()*cartItem.getQuantity();
			}
		return total;
	}

	@Override
	public Cart findCartById(Long id) throws Exception {
		Optional<Cart> optionalCart=cartRepository.findById(id);
		if(optionalCart.isEmpty()) {
			throw new Exception ("Card not found with this "+ id);
		}
		return optionalCart.get();
	}

	@Override
	public Cart findCartByUserId(Long userId) throws Exception {
//		User user=userService.findUserByJwtToken(jwt);
		return cartRepository.findByCustomerId(userId);
	}

	@Override
	public Cart clearCart(Long userId) throws Exception {
//		User user=userService.findUserByJwtToken(userId);
		Cart cart=findCartByUserId(userId);
		cart.getItem().clear();
		return cartRepository.save(cart);
	}

}
