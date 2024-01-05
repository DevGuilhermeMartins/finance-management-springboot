package com.cyberdata.management.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "category_expense")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryExpense implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	
	private String category;
	
	@JsonIgnore
	@OneToOne
	@MapsId
	private Expense expense;
	
	private String descriptionCategoryExpense;
}
