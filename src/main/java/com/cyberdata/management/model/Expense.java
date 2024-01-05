package com.cyberdata.management.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
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

@Entity
@Table(name = "expense")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Expense implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	
	@ManyToOne
	@JoinColumn(name = "account_id")
	private Account account;
	
	private String description;
	
	private BigDecimal value;
	
	private int quantity;
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private LocalDateTime timeOfExpense;
	
	@OneToOne(mappedBy = "expense", cascade = CascadeType.ALL)
	private CategoryExpense category;
	
	private String localExpense;
}
