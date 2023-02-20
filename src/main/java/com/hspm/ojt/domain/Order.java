package com.hspm.ojt.domain;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Orders")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long orderId;
	
	@NotBlank(message ="Customer name is required")
	private String customerName;
	
	//cartItem
	@NotBlank(message = "Product name should not be blank")
	private String productName;
	private Double price;
	private Integer quantity;
	
	
	//mainOrder
	private Double subTotal;
	private Double shippingCost;
	private Double grandTotal;
	
	
	
//	@JsonFormat(pattern = "yyyy-MM-dd")
//	private LocalDate orderDate;
//	@JsonFormat(pattern = "yyyy-MM-dd")
//	private LocalDate updateDate;
	
	
	
//	@Email(message = "Email must be email.")
//	private String email;
//	private String phone;
	//private String status = "active";
	
	@OneToOne(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.REFRESH, orphanRemoval = true)
	@JsonIgnore
	private Payment payment;
	
	//shippingAddress
	
//	private String street;
//	private String township;
//	private String city;
//	private String country;
	

//	@PrePersist
//	void onOrderDate() {
//		this.orderDate = LocalDate.now();
//	}
//	
//	@PreUpdate
//	void onUpdateOrder() {
//		this.updateDate = LocalDate.now();
//	}

}
