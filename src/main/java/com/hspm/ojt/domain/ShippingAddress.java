package com.hspm.ojt.domain;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class ShippingAddress {
	
	private Long id;
	private String street;
	private String township;
	private String city;

}
