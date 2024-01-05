package com.cyberdata.management.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "account")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String id;
	
	private String username;
	
	private String email;
	
	private String password;
	
	@OneToMany(mappedBy = "account")
	private List<Expense> expenses = new ArrayList<>();
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate registerDate;
	
	private String role;
}
