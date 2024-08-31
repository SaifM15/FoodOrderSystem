package com.foodsystem.Model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class IngredientCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String name;
	
//	@JsonIgnore
//	@ManyToMany
//	private Restaurant restaurant;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "ingredientCategories")
	private List<Restaurant> restaurants = new ArrayList<>();

	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private List<IngredientsItem> ingredients= new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Restaurant> getRestaurants() {
		return restaurants;
	}

	public void setRestaurants(	List<Restaurant> restaurants) {
		this.restaurants = restaurants;
	}

	public List<IngredientsItem> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<IngredientsItem> ingredients) {
		this.ingredients = ingredients;
	}

	@Override
	public String toString() {
		return "IngredientCategory [id=" + id + ", name=" + name + ", restaurants=" + restaurants + ", ingredients="
				+ ingredients + "]";
	}

	public IngredientCategory(Long id, String name, List<Restaurant> restaurants, List<IngredientsItem> ingredients) {
		super();
		this.id = id;
		this.name = name;
		this.restaurants = restaurants;
		this.ingredients = ingredients;
	}

	public IngredientCategory() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
