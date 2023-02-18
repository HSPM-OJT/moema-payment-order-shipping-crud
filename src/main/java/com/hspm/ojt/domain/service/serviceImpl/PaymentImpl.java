package com.hspm.ojt.domain.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.hspm.ojt.domain.Payment;
import com.hspm.ojt.repository.PaymentRepository;
import com.hspm.ojt.service.PaymentService;


@Service
public class PaymentImpl implements PaymentService{
	
	private final PaymentRepository paymentRepository;

	public PaymentImpl(PaymentRepository paymentRepository) {
		super();
		this.paymentRepository = paymentRepository;
	}

	@Override
	public Payment saveOrUpdate(Payment payment) {
		
//		Optional <Payment> paymentOpt = paymentRepository.findById(payment.getPaymentId());
//		if(paymentOpt.isPresent()) {
//			payment.setPaymentId(paymentOpt.get().getPaymentId());
//		}
		
		return paymentRepository.save(payment);
	}

	@Override
	public List<Payment> findAll() {
		
		return (List<Payment>) paymentRepository.findAll();
	}

	@Override
	public Optional<Payment> findByPaymentId(@PathVariable Long id) {
		
		return paymentRepository.findById(id);
	}

	@Override
	public void deleteByPaymentId(Long id) {
		
		paymentRepository.deleteById(id);
		
	}

}
