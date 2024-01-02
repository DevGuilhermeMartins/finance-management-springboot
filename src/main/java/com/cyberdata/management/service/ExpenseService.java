package com.cyberdata.management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cyberdata.management.model.Expense;
import com.cyberdata.management.repository.ExpenseRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExpenseService {

	private final ExpenseRepository expenseRepository;
	
		// Find Expense by id
		public Expense findById(String id) {
			return expenseRepository.findById(id).orElseThrow(() -> new RuntimeException("Resource not found: " + id));
		}
		
		// Find All Expenses in a List
		public List<Expense> findAllExpenses(){
			return expenseRepository.findAll();
		}
		
		// Creating Expense
		public Expense createExpense(Expense expense) {
			return expenseRepository.save(expense);
		}
		
		// Update Expense
		public Expense updateExpense(String id, Expense updateExpense) {
			Expense expenseEntity = expenseRepository.findById(id).orElseThrow(() -> new RuntimeException("Resource not found: " + id));
			updateExpense(expenseEntity, updateExpense);
			return expenseRepository.save(expenseEntity);
		}
		
		// Delete Expense
		public void deleteExpense(String id) {
			Expense expenseEntity = expenseRepository.findById(id).orElseThrow(() -> new RuntimeException("Resource not found: " + id));
			expenseRepository.delete(expenseEntity);
		}

		
		// Method to update Data using the updateExpense as body of new values
		private void updateExpense(Expense expenseEntity, Expense updateExpense) {
			expenseEntity.setDescription(updateExpense.getDescription());
			expenseEntity.setValue(updateExpense.getValue());
			expenseEntity.setTimeOfExpense(updateExpense.getTimeOfExpense());
			expenseEntity.setCategory(updateExpense.getCategory());
			expenseEntity.setLocalExpense(updateExpense.getLocalExpense());
		}
}
