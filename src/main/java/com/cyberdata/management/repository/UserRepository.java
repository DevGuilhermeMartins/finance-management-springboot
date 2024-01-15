package com.cyberdata.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.cyberdata.management.model.User;

public interface UserRepository extends JpaRepository<User, String>{

	UserDetails findByLogin(String login);
}
