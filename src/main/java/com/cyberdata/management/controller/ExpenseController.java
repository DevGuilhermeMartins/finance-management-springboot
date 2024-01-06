package com.cyberdata.management.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cyberdata.management.dto.ExpenseDTO;
import com.cyberdata.management.model.Expense;
import com.cyberdata.management.service.ExpenseService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/expense")
@RequiredArgsConstructor
public class ExpenseController {

	private final ExpenseService expenseService;

	@Autowired
	private ModelMapper modelMapper;

	@PostMapping
	public ResponseEntity<ExpenseDTO> saveExpense(@RequestBody ExpenseDTO expenseDTO) {
		// Convert DTO to Entity
		Expense expenseModel = modelMapper.map(expenseDTO, Expense.class);

		// Use the method to save the expense
		Expense expenseSave = expenseService.createExpense(expenseModel);

		// Convert Entity to DTO
		ExpenseDTO expenseResponse = modelMapper.map(expenseSave, ExpenseDTO.class);

		return new ResponseEntity<>(expenseResponse, HttpStatus.CREATED);
	}

	@GetMapping
	public List<ExpenseDTO> findAllExpenses() {
		return expenseService.findAllExpenses().stream().map(expense -> modelMapper.map(expense, ExpenseDTO.class))
				.collect(Collectors.toList());
	}

	@GetMapping("/{id}")
	public ResponseEntity<ExpenseDTO> findExpenseById(@PathVariable String id) {
		Expense expenseModel = expenseService.findById(id);

		// Convert Entity to DTO
		ExpenseDTO expenseResponse = modelMapper.map(expenseModel, ExpenseDTO.class);

		return ResponseEntity.ok().body(expenseResponse);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ExpenseDTO> updateExpense(@PathVariable String id, @RequestBody ExpenseDTO updateExpense) {
		Expense expenseModel = expenseService.findById(id);

		Expense expenseUpdate = expenseService.updateExpense(id, expenseModel);

		// Convert Entity to DTO
		ExpenseDTO expenseResponse = modelMapper.map(expenseUpdate, ExpenseDTO.class);

		return ResponseEntity.ok().body(expenseResponse);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteExpense(@PathVariable String id) {
		expenseService.deleteExpense(id);
		return ResponseEntity.noContent().build();
	}
}
