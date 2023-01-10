package com.hspm.ojt.domain;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Email
	@NotBlank(message = "Email is required")
	private String email;

	@NotBlank(message = "Phone Number is required")
	private String phone;

	@NotBlank(message = "Fullname is required")
	private String fullname;

	@NotBlank(message = "Password is required")
	private String password;

	@Transient
	@NotBlank(message = "ConfirmPassword is required")
	private String confirmPassword;

	private Status status = Status.ACTIVE;

	private LocalDate createdAt;
	private LocalDate updatedAt;

	public Admin(@Email @NotBlank(message = "Email is required") String email,
			@NotBlank(message = "Phone Number is required") String phone,
			@NotBlank(message = "Fullname is required") String fullname,
			@NotBlank(message = "Password is required") String password,
			@NotBlank(message = "ConfirmPassword is required") String confirmPassword, Status status) {
		super();
		this.email = email;
		this.phone = phone;
		this.fullname = fullname;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.status = status;
	}

	//for update
	public Admin(Long id, @Email @NotBlank(message = "Email is required") String email,
			@NotBlank(message = "Phone Number is required") String phone,
			@NotBlank(message = "Fullname is required") String fullname,
			@NotBlank(message = "Password is required") String password,
			@NotBlank(message = "ConfirmPassword is required") String confirmPassword, Status status) {
		super();
		this.id = id;
		this.email = email;
		this.phone = phone;
		this.fullname = fullname;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.status = status;
	}

	@PrePersist
	void onCreate() {
		this.createdAt = LocalDate.now();
	}

	@PreUpdate
	void onUpdate() {
		this.updatedAt = LocalDate.now();
	}

}
