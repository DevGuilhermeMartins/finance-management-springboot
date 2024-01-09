package com.cyberdata.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cyberdata.management.model.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long>{

}
