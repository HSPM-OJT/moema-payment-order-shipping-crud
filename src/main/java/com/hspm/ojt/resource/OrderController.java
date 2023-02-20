package com.hspm.ojt.resource;

import java.util.List;
import java.util.Optional;

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

import com.hspm.ojt.domain.Order;

import com.hspm.ojt.service.MapValidationErrorService;
import com.hspm.ojt.service.OrderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/order")
@CrossOrigin(origins = "http://localhost:3000")
public class OrderController {

	private  OrderService orderService;
	private MapValidationErrorService mapErrorService;
	
	
	public OrderController(OrderService orderService, MapValidationErrorService mapErrorService) {
		super();
		this.orderService = orderService;
		this.mapErrorService = mapErrorService;
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> createOrder(@Valid @RequestBody Order order ,BindingResult result){
		
		ResponseEntity<?> responseErrorObject = mapErrorService.validate(result);
		
		if(responseErrorObject != null) {
			return responseErrorObject;
		}
		Order createdOrder = orderService.saveOrUpdate(order);
		
		
		
		return new ResponseEntity<Order>(createdOrder,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/all")
	public List<Order> findAll(){
		return orderService.findAll();
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		
		Optional<Order> orderOptional = orderService.findByOrderId(id);
		
		if(orderOptional.isEmpty())
			return new ResponseEntity<String>("Order with id ="+id+" is not found",HttpStatus.NOT_FOUND);
		return new ResponseEntity<Order>(orderOptional.get(),HttpStatus.OK);
		
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Long id){
		
		orderService.deleteByOrderId(id);
		return new ResponseEntity<String> ("Delete id = "+id ,HttpStatus.OK);
		
	}
	
	
	
}
