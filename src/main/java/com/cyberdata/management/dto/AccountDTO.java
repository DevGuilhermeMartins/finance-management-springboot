package com.cyberdata.management.dto;

import java.time.LocalDate;
import java.util.List;

import com.cyberdata.management.model.Expense;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {

	private String username;
	private String email;
	private LocalDate registerDate;
	private List<Expense> expenses;
}
