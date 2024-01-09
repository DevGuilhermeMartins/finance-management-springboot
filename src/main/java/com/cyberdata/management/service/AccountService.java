package com.cyberdata.management.service;

import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.cyberdata.management.config.exceptions.DatabaseException;
import com.cyberdata.management.config.exceptions.ResourceNotFoundException;
import com.cyberdata.management.model.Account;
import com.cyberdata.management.repository.AccountRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountService {

	private final AccountRepository accountRepository;
	
	// Find Account by Id
	public Account findById(Long id) {
		return accountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
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
		try {
		Account accountEntity = accountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
		updateAccount(accountEntity, updateAccount);
		return accountRepository.save(accountEntity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id); 
		}
	}
	
	// Delete Account
	public void deleteAccount(Long id) {
		try {
		Account accountEntity = accountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
		accountRepository.delete(accountEntity);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	
	// Method to update Data using the updateAccount as body of new values
	private void updateAccount(Account accountEntity, Account updateAccount) {
		accountEntity.setUsername(updateAccount.getUsername());
		accountEntity.setEmail(updateAccount.getEmail());
		accountEntity.setPassword(updateAccount.getPassword());
		accountEntity.setRegisterDate(updateAccount.getRegisterDate());
	}
	
	
}
