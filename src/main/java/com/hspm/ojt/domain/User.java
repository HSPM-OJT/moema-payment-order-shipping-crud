package com.hspm.ojt.domain;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Users")
public class User { // generate key

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "User Name is required")
	private String fullname;

	@Email(message = "Email must be email")
	@NotBlank(message = "Email is required")
	private String email;

	@NotBlank(message = "Phone Number is required")
	private String phoneNumber;

	@NotBlank(message = "Password is required")
	private String password;

	@NotBlank(message = "Confirm Password is required")
	@Transient
	private String confirmPassword;

	private String status = "active";

	private String role = "customer";

	private LocalDate createdAt;
	private LocalDate updatedAt;

	@PrePersist
	void OnCreate() {
		this.createdAt = LocalDate.now();
	}

	@PreUpdate
	void OnUpdate() {
		this.updatedAt = LocalDate.now();
	}

	public User(@NotBlank(message = "User Name is required") String fullname,
			@Email(message = "Email must be email") @NotBlank(message = "Email is required") String email,
			@NotBlank(message = "Phone Number is required") String phoneNumber,
			@NotBlank(message = "Password is required") String password,
			@NotBlank(message = "Confirm Password is required") String confirmPassword, String status, String role) {
		super();
		this.fullname = fullname;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.status = status;
		this.role = role;
	}

//
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//
//	@Override
//	public String getUsername() {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
