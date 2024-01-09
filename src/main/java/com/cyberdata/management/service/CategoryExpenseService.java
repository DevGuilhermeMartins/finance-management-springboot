package com.cyberdata.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.cyberdata.management.config.exceptions.DatabaseException;
import com.cyberdata.management.config.exceptions.ResourceNotFoundException;
import com.cyberdata.management.model.CategoryExpense;
import com.cyberdata.management.repository.CategoryExpenseRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryExpenseService {

    private final CategoryExpenseRepository categoryExpenseRepository;
	
    
    // Find CategoryExpense by Category name
	public CategoryExpense findByCategory(String category) {
		Optional<CategoryExpense> obj = categoryExpenseRepository.findByCategory(category);
		return obj.orElseThrow(() -> new ResourceNotFoundException("Resource not found: " + category));
	}
	
	public CategoryExpense findById(Long id) {
		Optional<CategoryExpense> obj = categoryExpenseRepository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException("Resource not found: " + id));
	}
	
	// Find All CategoryExpenses in a List
	public List<CategoryExpense> findAllCategoryExpenses(){
		return categoryExpenseRepository.findAll();
	}
	
	// Creating CategoryExpense
	public CategoryExpense createCategoryExpense(CategoryExpense categoryExpense) {
		return categoryExpenseRepository.save(categoryExpense);
	}
	
	// Update CategoryExpense
	public CategoryExpense updateCategoryExpense(Long id, CategoryExpense updateCategoryExpense) {
		try {
		CategoryExpense categoryExpenseEntity = categoryExpenseRepository.findById(id).orElseThrow(() -> new RuntimeException("Resource not found: " + id));
		updateCategoryExpense(categoryExpenseEntity, updateCategoryExpense);
		return categoryExpenseRepository.save(categoryExpenseEntity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Resource not found: " + id);
		}
	}
	
	// Delete CategoryExpense
	public void deleteCategoryExpense(Long id) {
		try {
		CategoryExpense categoryExpenseEntity = categoryExpenseRepository.findById(id).orElseThrow(() -> new RuntimeException("Resource not found: " + id));
		categoryExpenseRepository.delete(categoryExpenseEntity);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Resource not found: " + id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	
	// Method to update Data using the updateCategoryExpense as body of new values
	private void updateCategoryExpense(CategoryExpense categoryExpenseEntity, CategoryExpense updateCategoryExpense) {
		categoryExpenseEntity.setCategory(updateCategoryExpense.getCategory());
		categoryExpenseEntity.setDescriptionCategoryExpense(updateCategoryExpense.getDescriptionCategoryExpense());
	}
	
	
}
