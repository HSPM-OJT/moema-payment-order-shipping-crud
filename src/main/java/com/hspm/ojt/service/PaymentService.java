package com.hspm.ojt.service;

import java.util.List;
import java.util.Optional;

import com.hspm.ojt.domain.Payment;


public interface PaymentService {
	
	
	Payment saveOrUpdate(Payment payment);
	
	List<Payment> findAll();
	
	Optional<Payment> findByPaymentId(Long id);

	void deleteByPaymentId(Long id);
	
	

}
