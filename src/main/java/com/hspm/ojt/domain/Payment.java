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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long paymentId;
	
	
	@NotBlank(message = "CardNumber should not be blank")
	@Size(min = 15,max = 16,message = "15 or 16 charactor should be included")
	private String cardNumber;
	
	@NotBlank(message = "CVC should not be blank")
	@Size(min = 3,max = 4,message = "3 or 4 charactor should be included") 
	private String cvc;
	
	@NotBlank(message = "HolderName should not be blank")
	private String holderName;
	
	@NotBlank(message = "Card Type should not be blank")
	private String cardType;
	
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate expireDate;


	@OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinColumn(name="order_id")
	@JsonIgnore
	private Order order;
	

	public Payment(String cardNumber, String cvc, String holderName, String cardType,LocalDate expireDate) {
		super();
		this.cardNumber = cardNumber;
		this.cvc = cvc;
		this.holderName = holderName;
		this.cardType = cardType;
		this.expireDate = expireDate;
	}
	


}
