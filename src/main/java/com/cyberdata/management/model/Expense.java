package com.cyberdata.management.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "expense")
@Table(name = "expense")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Expense implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String description;
	
	private BigDecimal value;
	
	private int quantity;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime timeOfExpense;
	
	@OneToOne
	@JoinColumn(name = "category_expense_id")
	private CategoryExpense category;
	
	private String localExpense;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "account_id")
	private Account account;
}
