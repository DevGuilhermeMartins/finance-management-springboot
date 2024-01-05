package com.cyberdata.management.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "category_expense")
@Table(name = "category_expense")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryExpense implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String category;
	
	@OneToOne(mappedBy = "category")
	private Expense expense;
	
	private String descriptionCategoryExpense;
}
