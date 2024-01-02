package com.cyberdata.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cyberdata.management.model.CategoryExpense;

public interface CategoryExpenseRepository extends JpaRepository<CategoryExpense, String>{

	CategoryExpense findByCategory(String category);
}
