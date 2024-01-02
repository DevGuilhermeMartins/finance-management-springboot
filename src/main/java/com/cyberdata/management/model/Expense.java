package com.cyberdata.management.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "expense")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Expense {

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	
	private String description;
	
	private BigDecimal value;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime timeOfExpense;
	
	private CategoryExpense category;
	
	private String localExpense;
}
