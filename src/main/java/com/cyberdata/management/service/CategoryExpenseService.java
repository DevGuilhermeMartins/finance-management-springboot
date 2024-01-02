package com.cyberdata.management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cyberdata.management.model.CategoryExpense;
import com.cyberdata.management.repository.CategoryExpenseRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryExpenseService {

    private final CategoryExpenseRepository categoryExpenseRepository;
	
    
    // Find CategoryExpense by Category name
	public CategoryExpense findById(String category) {
		return categoryExpenseRepository.findByCategory(category);
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
	public CategoryExpense updateCategoryExpense(String id, CategoryExpense updateCategoryExpense) {
		CategoryExpense categoryExpenseEntity = categoryExpenseRepository.findById(id).orElseThrow(() -> new RuntimeException("Resource not found: " + id));
		updateCategoryExpense(categoryExpenseEntity, updateCategoryExpense);
		return categoryExpenseRepository.save(categoryExpenseEntity);
	}
	
	// Delete CategoryExpense
	public void deleteCategoryExpense(String id) {
		CategoryExpense categoryExpenseEntity = categoryExpenseRepository.findById(id).orElseThrow(() -> new RuntimeException("Resource not found: " + id));
		categoryExpenseRepository.delete(categoryExpenseEntity);
	}

	
	// Method to update Data using the updateCategoryExpense as body of new values
	private void updateCategoryExpense(CategoryExpense categoryExpenseEntity, CategoryExpense updateCategoryExpense) {
		categoryExpenseEntity.setCategory(updateCategoryExpense.getCategory());
		categoryExpenseEntity.setDescriptionCategoryExpense(updateCategoryExpense.getDescriptionCategoryExpense());
	}
	
	
}
