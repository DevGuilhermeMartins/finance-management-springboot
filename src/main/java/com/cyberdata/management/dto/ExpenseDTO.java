package com.cyberdata.management.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.cyberdata.management.model.CategoryExpense;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseDTO {

	private String description;
	private BigDecimal value;
	private LocalDateTime timeOfExpense;
	private CategoryExpense category;
	private String localExpense;
}
