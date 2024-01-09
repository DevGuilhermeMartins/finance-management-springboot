package com.cyberdata.management.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cyberdata.management.model.CategoryExpense;

public interface CategoryExpenseRepository extends JpaRepository<CategoryExpense, Long>{

	Optional<CategoryExpense> findByCategory(String category);
}
