package com.foodsystem.Request;

import java.util.List;

import com.foodsystem.Model.Address;
import com.foodsystem.Model.ContactInformation;

import lombok.Data;

@Data
public class CreateRestaurantRequest {
	
	private Long id;
	
	private String name;
	
	private String description;
	
	private String cuisineType;
	
	private Address address;
	
	private ContactInformation contactInformation;
	
	private String openingHours;

	private List<String> images;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCuisineType() {
		return cuisineType;
	}

	public void setCuisineType(String cuisineType) {
		this.cuisineType = cuisineType;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public ContactInformation getContactInformation() {
		return contactInformation;
	}

	public void setContactInformation(ContactInformation contactInformation) {
		this.contactInformation = contactInformation;
	}

	public String getOpeningHours() {
		return openingHours;
	}

	public void setOpeningHours(String openingHours) {
		this.openingHours = openingHours;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}

	@Override
	public String toString() {
		return "CreateRestaurantRequest [id=" + id + ", name=" + name + ", description=" + description
				+ ", cuisineType=" + cuisineType + ", address=" + address + ", contactInformation=" + contactInformation
				+ ", openingHours=" + openingHours + ", images=" + images + "]";
	}

	public CreateRestaurantRequest(Long id, String name, String description, String cuisineType, Address address,
			ContactInformation contactInformation, String openingHours, List<String> images) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.cuisineType = cuisineType;
		this.address = address;
		this.contactInformation = contactInformation;
		this.openingHours = openingHours;
		this.images = images;
	}

	public CreateRestaurantRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
