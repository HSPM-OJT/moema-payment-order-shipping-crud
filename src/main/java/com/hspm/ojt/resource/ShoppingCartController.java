package com.hspm.ojt.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hspm.ojt.domain.ShoppingCart;
import com.hspm.ojt.service.ShoppingCartService;

@RestController
@RequestMapping("/api/shoppingcart")
public class ShoppingCartController {
	
	private final ShoppingCartService shoppingCartService;

	@Autowired
	public ShoppingCartController(ShoppingCartService shoppingCartService) {
		super();
		this.shoppingCartService = shoppingCartService;
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> crateShoppingCart(ShoppingCart shoppingCart){
		
		ShoppingCart createdShoppingCart = shoppingCartService.saveOrUpdate(shoppingCart);
		
		return new ResponseEntity<ShoppingCart>(createdShoppingCart,HttpStatus.CREATED);
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> findAll(){
		
		List<ShoppingCart> shoppingCartList = shoppingCartService.findAll();
		
		if(shoppingCartList.isEmpty()) {
			return new ResponseEntity<String>("No ShoppingCart in your account",HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<List<ShoppingCart>>(shoppingCartList,HttpStatus.OK);
	}
	
	@GetMapping("/id/{id}")
	public ResponseEntity<?> findById(@PathVariable Long id){
		
		Optional<ShoppingCart> shoppingCartOpt = shoppingCartService.findByShoppingCartId(id);
		
		if(shoppingCartOpt.isEmpty())
			return new ResponseEntity<>("ShoppingCart with id = "+id+" is not found",HttpStatus.NOT_FOUND);
		
		return new ResponseEntity<ShoppingCart>(shoppingCartOpt.get(),HttpStatus.OK);
	}

}
