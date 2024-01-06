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

import com.cyberdata.management.dto.AccountDTO;
import com.cyberdata.management.model.Account;
import com.cyberdata.management.service.AccountService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

	private final AccountService accountService;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping
	public ResponseEntity<AccountDTO> saveAccount(@RequestBody AccountDTO accountDTO){
		// Convert DTO to Entity
		Account accountModel = modelMapper.map(accountDTO, Account.class);
		
		// Use the method to save the account
		Account accountSave = accountService.saveAccount(accountModel);
		
		// Convert Entity to DTO
		AccountDTO accountResponse = modelMapper.map(accountSave, AccountDTO.class);
		
		return new ResponseEntity<>(accountResponse, HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<AccountDTO> findAllAccounts(){
		return accountService.findAllAccounts().stream().map(account -> modelMapper.map(account, AccountDTO.class))
				.collect(Collectors.toList());
	}
	
	@GetMapping("/{email}")
	public ResponseEntity<AccountDTO> findAccountByEmail(@PathVariable String email){
		Account accountModel = accountService.findByEmail(email);
		
		// Convert Entity to DTO
		AccountDTO accountResponse = modelMapper.map(accountModel, AccountDTO.class);
		
		return ResponseEntity.ok().body(accountResponse);
	}
	
	@PutMapping("/{email}")
	public ResponseEntity<AccountDTO> updateAccount(@PathVariable String email, @RequestBody AccountDTO updateAccount){
		Account accountModel = accountService.findByEmail(email);
		
		Account accountUpdate = accountService.updateAccount(email, accountModel);
		
		// Convert Entity to DTO
		AccountDTO accountResponse = modelMapper.map(accountUpdate, AccountDTO.class);
		
		return ResponseEntity.ok().body(accountResponse);
	}
	
	@DeleteMapping("/{email}")
	public ResponseEntity<Void> deleteAccount(@PathVariable String email){
		accountService.deleteAccount(email);
		return ResponseEntity.noContent().build();
	}
}
