package com.foodsystem.Model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	private Food food;
	
	private int quantity;
	
	private Long totalPrice;
	
	private List<String> ingrediants;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Long getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Long totalPrice) {
		this.totalPrice = totalPrice;
	}

	public List<String> getIngrediants() {
		return ingrediants;
	}

	public void setIngrediants(List<String> ingrediants) {
		this.ingrediants = ingrediants;
	}

	@Override
	public String toString() {
		return "OrderItem [id=" + id + ", food=" + food + ", quantity=" + quantity + ", totalPrice=" + totalPrice
				+ ", ingrediants=" + ingrediants + "]";
	}

	public OrderItem(Long id, Food food, int quantity, Long totalPrice, List<String> ingrediants) {
		super();
		this.id = id;
		this.food = food;
		this.quantity = quantity;
		this.totalPrice = totalPrice;
		this.ingrediants = ingrediants;
	}

	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
