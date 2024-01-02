package com.cyberdata.management.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "category_expense")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryExpense {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	
	private String category;
	
	private String descriptionCategoryExpense;
}
