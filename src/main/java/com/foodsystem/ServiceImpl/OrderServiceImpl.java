package com.foodsystem.ServiceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.tomcat.util.openssl.openssl_h;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.foodsystem.Model.Address;
import com.foodsystem.Model.Cart;
import com.foodsystem.Model.CartItem;
import com.foodsystem.Model.Order;
import com.foodsystem.Model.OrderItem;
import com.foodsystem.Model.Restaurant;
import com.foodsystem.Model.User;
import com.foodsystem.Repository.AddressRepository;
import com.foodsystem.Repository.OrderItemRepository;
import com.foodsystem.Repository.OrderRepository;
import com.foodsystem.Repository.UserRepository;
import com.foodsystem.Request.OrderRequest;
import com.foodsystem.Service.CartService;
import com.foodsystem.Service.OrderService;
import com.foodsystem.Service.RestaurantService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderItemRepository OrderItemRepository;

	@Autowired
	private AddressRepository addressRepository;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestaurantService restaurantService;

	@Autowired
	private CartService cartService;

	@Override
	public Order createOrder(OrderRequest order, User user) throws Exception {

		Address shippingAddress = order.getDeliveryAddress();

		Address savedAddress = addressRepository.save(shippingAddress);

		if (!user.getAddresses().contains(savedAddress)) {
			user.getAddresses().add(savedAddress);
			userRepository.save(user);
		}

		Restaurant restaurant = restaurantService.findRestaurantById(order.getRestaurantId());

		Order createdOrder = new Order();
		createdOrder.setCustomer(user);
		createdOrder.setCreatedAt(new Date());
		createdOrder.setOrderStatus("PENDING");
		createdOrder.setDeliveryAddress(savedAddress);
		createdOrder.setRestaurant(restaurant);

		Cart cart = cartService.findCartById(user.getId());

		List<OrderItem> orderItems = new ArrayList<>();

		for (CartItem cartItem : cart.getItem()) {
			OrderItem orderItem = new OrderItem();
			orderItem.setFood(cartItem.getFood());
			orderItem.setIngrediants(cartItem.getIngredients());
			orderItem.setQuantity(cartItem.getQuantity());
			orderItem.setTotalPrice(cartItem.getTotalPrice());

			OrderItem savedOrderItems = OrderItemRepository.save(orderItem);
			orderItems.add(savedOrderItems);
		}
		Long totalPrice = cartService.calculateCartTotals(cart);
		createdOrder.setItems(orderItems);
		createdOrder.setTotalPrice(totalPrice);

		Order savedOrder = orderRepository.save(createdOrder);
		restaurant.getOrders().add(savedOrder);

		return createdOrder;
	}

	@Override
	public Order updateOrder(Long orderId, String orderStatus) throws Exception {
		Order order =findOrderById(orderId);
		{
			if(orderStatus.equals("OUT_FOR_DELIVERY")
					||orderStatus.equals("DELIVERED")
					||orderStatus.equals("COMPLETED")
					||orderStatus.equals("PENDING")) {
				order.setOrderStatus(orderStatus);
				return orderRepository.save(order);
			}
			 throw new Exception("Please Select valid order Status");
		}
		
		
	}

	@Override
	public void cancelOrder(Long orderId) throws Exception {

		Order order = findOrderById(orderId);
		orderRepository.deleteById(orderId);
	}

	@Override
	public List<Order> getUserOrder(Long userId) throws Exception {
	
		return orderRepository.findByCustomerId(userId);
	}

	@Override
	public List<Order> getRestaurantOrder(Long restaurantId, String orderStatus) throws Exception {
		// TODO Auto-generated method stub
		List<Order> orders=orderRepository.findByRestaurantId(restaurantId);
		if(orderStatus!=null) {
			orders = orders.stream().filter(order->order.getOrderStatus()
					.equals(orderStatus)).collect(Collectors.toList());
		}
		return orders;
	}

	@Override
	public Order findOrderById(Long orderId) throws Exception {
		Optional<Order>optionalOrder=orderRepository.findById(orderId);
		if(optionalOrder.isEmpty()) {
			throw new Exception("Order not found");
		}
		return optionalOrder.get();
	}

}
