package com.hspm.ojt.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hspm.ojt.domain.Payment;
import com.hspm.ojt.service.MapValidationErrorService;
import com.hspm.ojt.service.PaymentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/payment")
@CrossOrigin(origins = "http://localhost:3000")
public class PaymentController {
	
	private final PaymentService paymentService;
	private final MapValidationErrorService mapErrorService;
	
	@Autowired
	public PaymentController(PaymentService paymentService, MapValidationErrorService mapErrorService) {
		super();
		this.paymentService = paymentService;
		this.mapErrorService = mapErrorService;
	}
	
	@PostMapping("/create/{id}")
	public ResponseEntity<?> createPayment(@Valid @RequestBody Payment payment,BindingResult result,@PathVariable Long id){
		
		ResponseEntity<?> responseErrorObject = mapErrorService.validate(result);
		
		if(responseErrorObject != null) {
			return responseErrorObject;
		}

		Payment createdPayment = paymentService.saveOrUpdate(payment, id);
		
		
		
		return new ResponseEntity<Payment>(createdPayment,HttpStatus.CREATED);
		
	}
	
//	@PostMapping("/update")
//	public ResponseEntity<?> createPayment(@Valid @RequestBody Payment payment,BindingResult result){
//		
//		ResponseEntity<?> responseErrorObject = mapErrorService.validate(result);
//		
//		if(responseErrorObject != null) {
//			return responseErrorObject;
//		}
//
//		Payment createdPayment = paymentService.saveOrUpdate(payment);
//		
//		
//		
//		return new ResponseEntity<Payment>(createdPayment,HttpStatus.CREATED);
//		
//	}
	
	@GetMapping("/all")
	public List<Payment> findAll(){
		return paymentService.findAll();
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		
		Optional<Payment> paymentOptional = paymentService.findByPaymentId(id);
		
		if(paymentOptional.isEmpty())
			return new ResponseEntity<String>("Payment with id ="+id+" is not found",HttpStatus.NOT_FOUND);
		return new ResponseEntity<Payment>(paymentOptional.get(),HttpStatus.OK);
		
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id){
		
		paymentService.deleteByPaymentId(id);
		return new ResponseEntity<String> ("Delete id = "+id ,HttpStatus.OK);
		
	}
	
	
	
	
	

}
