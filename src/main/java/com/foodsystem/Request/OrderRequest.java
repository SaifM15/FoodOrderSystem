package com.foodsystem.Request;

import com.foodsystem.Model.Address;

import lombok.Data;

@Data
public class OrderRequest {
	
	private Long restaurantId;
	
	private Address deliveryAddress;

	public Long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}

	public Address getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(Address deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	@Override
	public String toString() {
		return "OrderRequest [restaurantId=" + restaurantId + ", deliveryAddress=" + deliveryAddress + "]";
	}

	public OrderRequest(Long restaurantId, Address deliveryAddress) {
		super();
		this.restaurantId = restaurantId;
		this.deliveryAddress = deliveryAddress;
	}

	public OrderRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
