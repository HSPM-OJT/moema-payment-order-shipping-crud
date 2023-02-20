package com.hspm.ojt.domain.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.hspm.ojt.domain.Order;
import com.hspm.ojt.domain.Payment;
import com.hspm.ojt.repository.OrderRepository;
import com.hspm.ojt.repository.PaymentRepository;
import com.hspm.ojt.service.PaymentService;


@Service
public class PaymentImpl implements PaymentService{
	
	private final PaymentRepository paymentRepo;
	private final OrderRepository orderRepo;

	

	public PaymentImpl(PaymentRepository paymentRepo, OrderRepository orderRepo) {
		super();
		this.paymentRepo = paymentRepo;
		this.orderRepo = orderRepo;
	}

	@Override
	public Payment saveOrUpdate(Payment payment,Long id) {
		
//		Optional <Payment> paymentOpt = paymentRepository.findById(payment.getPaymentId());
//		if(paymentOpt.isPresent()) {
//			payment.setPaymentId(paymentOpt.get().getPaymentId());
//		
//		}
		Order order = orderRepo.findById(id).get();
		order.setPayment(payment);
		payment.setOrder(order);
		
		
		return paymentRepo.save(payment);
	}

	@Override
	public List<Payment> findAll() {
		
		return (List<Payment>) paymentRepo.findAll();
	}

	@Override
	public Optional<Payment> findByPaymentId(@PathVariable Long id) {
		
		return paymentRepo.findById(id);
	}

	@Override
	public void deleteByPaymentId(Long id) {
		
		paymentRepo.deleteById(id);
		
	}

//	@Override
//	public Payment updatePayment(Payment payment) {
//		
//		return paymentRepo.save(payment);
//	}


}
