package com.cyberdata.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cyberdata.management.model.Account;

public interface AccountRepository extends JpaRepository<Account, Long>{
	
}
