package com.cyberdata.management.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum UserRole {
	
	ADMIN("admin"),
	
	USER("user");
	
	private String role;
}
