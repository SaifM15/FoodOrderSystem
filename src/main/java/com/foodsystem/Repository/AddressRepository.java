package com.foodsystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.foodsystem.Model.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{
	
	

}
