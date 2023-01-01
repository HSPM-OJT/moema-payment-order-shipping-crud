package com.hspm.ojt.domain;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
	
	private Long id;
	private String name;
	private Double price;
	private Integer quantity;
	private String description;
	private LocalDate stockin;
	private LocalDate stockout;
	

}
