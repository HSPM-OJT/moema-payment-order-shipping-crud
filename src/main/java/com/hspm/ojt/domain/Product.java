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

	@NotBlank(message = "Product code is required")
	private String productCode;

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
	private String status = "active";

	@PrePersist
	void stockIn() {
		this.stockin = LocalDate.now();
	}

	public Product(@NotBlank(message = "Product code is required") String productCode,
			@NotBlank(message = "Product Name is required") String productName,
			@NotNull(message = "Price is required") Double price, Integer quantity,
			@NotBlank(message = "Product Description is required") String description) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
		this.description = description;
	}

}
