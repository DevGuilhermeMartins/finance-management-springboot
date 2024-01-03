package com.cyberdata.management.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
}
