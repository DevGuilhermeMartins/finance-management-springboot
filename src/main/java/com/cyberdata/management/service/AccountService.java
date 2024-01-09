package com.cyberdata.management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cyberdata.management.config.exceptions.ResourceNotFoundException;
import com.cyberdata.management.model.Account;
import com.cyberdata.management.repository.AccountRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountService {

	private final AccountRepository accountRepository;
	
	// Find Account by Id
	public Account findById(Long id) {
		return accountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not found: " + id));
	}
	
	// Find All Accounts in a List
	public List<Account> findAllAccounts(){
		return accountRepository.findAll();
	}
	
	// Creating Account
	public Account saveAccount(Account account) {
		return accountRepository.save(account);
	}
	
	// Update Account
	public Account updateAccount(Long id, Account updateAccount) {
		Account accountEntity = accountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not found: " + id));
		updateAccount(accountEntity, updateAccount);
		return accountRepository.save(accountEntity);
	}
	
	// Delete Account
	public void deleteAccount(Long id) {
		Account accountEntity = accountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Resource not found: " + id));
		accountRepository.delete(accountEntity);
	}

	
	// Method to update Data using the updateAccount as body of new values
	private void updateAccount(Account accountEntity, Account updateAccount) {
		accountEntity.setUsername(updateAccount.getUsername());
		accountEntity.setEmail(updateAccount.getEmail());
		accountEntity.setPassword(updateAccount.getPassword());
		accountEntity.setRegisterDate(updateAccount.getRegisterDate());
	}
	
	
}
