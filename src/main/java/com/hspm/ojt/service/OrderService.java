package com.hspm.ojt.service;

import java.util.List;
import java.util.Optional;

import com.hspm.ojt.domain.Order;


public interface OrderService {
	
	Order saveOrUpdate(Order order);
	
	List<Order> findAll();
	
	Optional<Order> findByOrderId(Long id);

	void deleteByOrderId(Long id);

}
