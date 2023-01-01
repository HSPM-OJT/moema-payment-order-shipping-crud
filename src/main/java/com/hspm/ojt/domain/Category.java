package com.hspm.ojt.domain;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class Category {
	
	private Long id;
	private String categoryType;

}
