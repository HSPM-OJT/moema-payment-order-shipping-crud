package com.hspm.ojt.domain;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Order {
	
	private Long id;
	private Double subTotal;
	private Double shippingCost;
	private Double grandTotal;

}
