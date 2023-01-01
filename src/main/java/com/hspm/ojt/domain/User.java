package com.hspm.ojt.domain;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	private Long id;
	private String email;
	private String phoneNumber;
	private String password;
	private String fname;
	private String lname;
	private Users role = Users.CUSTOMER;
	

}
