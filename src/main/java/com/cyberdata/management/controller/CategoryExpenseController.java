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

import com.cyberdata.management.dto.CategoryExpenseDTO;
import com.cyberdata.management.model.CategoryExpense;
import com.cyberdata.management.service.CategoryExpenseService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/category-expense")
@RequiredArgsConstructor
public class CategoryExpenseController {

	private final CategoryExpenseService categoryExpenseService;

	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping
	public ResponseEntity<CategoryExpenseDTO> saveCategoryExpense(@RequestBody CategoryExpenseDTO categoryCategoryExpenseDTO) {
		// Convert DTO to Entity
		CategoryExpense categoryCategoryExpenseModel = modelMapper.map(categoryCategoryExpenseDTO, CategoryExpense.class);

		// Use the method to save the categoryCategoryExpense
		CategoryExpense categoryCategoryExpenseSave = categoryExpenseService.createCategoryExpense(categoryCategoryExpenseModel);

		// Convert Entity to DTO
		CategoryExpenseDTO categoryCategoryExpenseResponse = modelMapper.map(categoryCategoryExpenseSave, CategoryExpenseDTO.class);

		return new ResponseEntity<>(categoryCategoryExpenseResponse, HttpStatus.CREATED);
	}

	@GetMapping
	public List<CategoryExpenseDTO> findAllCategoryExpenses() {
		return categoryExpenseService.findAllCategoryExpenses().stream().map(categoryCategoryExpense -> modelMapper.map(categoryCategoryExpense, CategoryExpenseDTO.class))
				.collect(Collectors.toList());
	}

	@GetMapping("/{id}")
	public ResponseEntity<CategoryExpenseDTO> findCategoryExpenseById(@PathVariable Long id) {
		CategoryExpense categoryCategoryExpenseModel =  categoryExpenseService.findById(id);

		// Convert Entity to DTO
		CategoryExpenseDTO categoryCategoryExpenseResponse = modelMapper.map(categoryCategoryExpenseModel, CategoryExpenseDTO.class);

		return ResponseEntity.ok().body(categoryCategoryExpenseResponse);
	}

	@PutMapping("/{id}")
	public ResponseEntity<CategoryExpenseDTO> updateCategoryExpense(@PathVariable Long id, @RequestBody CategoryExpenseDTO updateCategoryExpense) {
		CategoryExpense categoryCategoryExpenseModel = categoryExpenseService.findById(id);

		CategoryExpense categoryCategoryExpenseUpdate = categoryExpenseService.updateCategoryExpense(id, categoryCategoryExpenseModel);

		// Convert Entity to DTO
		CategoryExpenseDTO categoryCategoryExpenseResponse = modelMapper.map(categoryCategoryExpenseUpdate, CategoryExpenseDTO.class);

		return ResponseEntity.ok().body(categoryCategoryExpenseResponse);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteCategoryExpense(@PathVariable Long id) {
		categoryExpenseService.deleteCategoryExpense(id);
		return ResponseEntity.noContent().build();
	}
}
