package com.hspm.ojt.service;

import java.util.List;
import java.util.Optional;

import com.hspm.ojt.domain.ShoppingCart;

public interface ShoppingCartService {
	
	ShoppingCart saveOrUpdate(ShoppingCart shoppingCart);
	
	List<ShoppingCart> findAll();
	
	Optional<ShoppingCart> findByShoppingCartId(Long id);

}
