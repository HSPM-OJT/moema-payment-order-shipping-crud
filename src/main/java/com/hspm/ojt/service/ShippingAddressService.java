package com.hspm.ojt.service;

import java.util.List;
import java.util.Optional;

import com.hspm.ojt.domain.ShippingAddress;


public interface ShippingAddressService {
	
	ShippingAddress saveOrUpdate(ShippingAddress shippingAddress);
	
	List<ShippingAddress> findAll();
	
	Optional<ShippingAddress> findShippingAddressById(Long id);
	
	void deleteByShippingAddressId(Long id);

}
