package com.hspm.ojt.domain.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.hspm.ojt.domain.Order;
import com.hspm.ojt.repository.OrderRepository;
import com.hspm.ojt.service.OrderService;

@Service
public class OrderImpl implements OrderService{
	
	
	private final OrderRepository orderRepo;
	
	
	public OrderImpl(OrderRepository orderRepo) {
		super();
		this.orderRepo = orderRepo;
	}

	@Override
	public Order saveOrUpdate(Order order) {
		
//		Double subTotal = (double) (order.getPrice() * order.getQuantity());
//		order.setSubTotal(subTotal);
//		
//		Double grandTotal = order.getShippingCost() + subTotal;
//		order.setGrandTotal(grandTotal);
		
		return orderRepo.save(order);
	}

	@Override
	public List<Order> findAll() {
		// TODO Auto-generated method stub
		return (List<Order>) orderRepo.findAll();
	}

	@Override
	public Optional<Order> findByOrderId(Long id) {
		
		return orderRepo.findById(id);
	}

	@Override
	public void deleteByOrderId(Long id) {
		orderRepo.deleteById(id);
		
	}

}
