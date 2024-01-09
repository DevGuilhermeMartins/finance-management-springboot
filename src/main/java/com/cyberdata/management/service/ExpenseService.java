package com.cyberdata.management.service;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.cyberdata.management.config.exceptions.DatabaseException;
import com.cyberdata.management.config.exceptions.ResourceNotFoundException;
import com.cyberdata.management.model.Expense;
import com.cyberdata.management.repository.ExpenseRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExpenseService {

	private final ExpenseRepository expenseRepository;
	
		// Find Expense by Id
		public Expense findById(Long id) {
			return expenseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not found: " + id));
		}
	
		// Find All Expenses in a List
		public List<Expense> findAllExpenses(){
			return expenseRepository.findAll();
		}
		
		// Creating Expense
		public Expense saveExpense(Expense expense) {
			return expenseRepository.save(expense);
		}
		
		// Update Expense
		public Expense updateExpense(Long id, Expense updateExpense) {
			try {
			Expense expenseEntity = expenseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not found: " + id));
			updateExpense(expenseEntity, updateExpense);
			return expenseRepository.save(expenseEntity);
			} catch (EntityNotFoundException e) {
				throw new ResourceNotFoundException("Resource not found: " + id); 
			}
		}
		
		// Delete Expense
		public void deleteExpense(Long id) {
			try {
			Expense expenseEntity = expenseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not found: " + id));
			expenseRepository.delete(expenseEntity);
			} catch (EmptyResultDataAccessException e) {
				throw new ResourceNotFoundException("Resource not found: " + id);
			} catch (DataIntegrityViolationException e) {
				throw new DatabaseException(e.getMessage());
			}
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
