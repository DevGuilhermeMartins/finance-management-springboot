package com.cyberdata.management.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cyberdata.management.model.Account;
import com.cyberdata.management.repository.AccountRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountService {

	private final AccountRepository accountRepository;
	
	// Using Email to find account
	public Account findByEmail(String email) {
		return accountRepository.findByEmail(email);
	}
	
	// Find All Accounts in a List
	public List<Account> findAllAccounts(){
		return accountRepository.findAll();
	}
	
	// Creating Account
	public Account createAccount(Account account) {
		return accountRepository.save(account);
	}
	
	// Update Account
	public Account updateAccount(String email, Account updateAccount) {
		Account accountEntity = accountRepository.findByEmail(email);
		updateAccount(accountEntity, updateAccount);
		return accountRepository.save(accountEntity);
	}
	
	// Delete Account
	public void deleteAccount(String email) {
		Account accountEntity = accountRepository.findByEmail(email);
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
