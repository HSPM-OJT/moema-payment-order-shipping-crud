package com.hspm.ojt.domain;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Product Name is required")
	private String productName;
	
	@NotNull(message = "Price is required")
	private Double price;
	
	private Integer quantity;
	
	@NotBlank(message = "Product Description is required")
	private String description;
	
	private LocalDate stockin;
	private LocalDate stockout;
	private LocalDate expireDate;
	
	@PrePersist
	void stockIn() {
		this.stockin = LocalDate.now();
	}
	

}
