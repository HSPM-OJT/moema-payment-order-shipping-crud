package com.hspm.ojt.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShippingAddress {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long shippingAddressId;
	
	@NotBlank(message = "Street is required")
	private String street;
	
	@NotBlank(message = "Township is required")
	private String township;
	
	@NotBlank(message = "City is required")
	private String city;
	
	@NotBlank(message = "PostalCode is required")
	private String postalCode;

	public ShippingAddress(String street,String township,String city,String postalCode) {
		super();
		this.street = street;
		this.township = township;
		this.city = city;
		this.postalCode = postalCode;
	}
	
	
	

}
