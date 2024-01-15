package com.cyberdata.management.dto;

import com.cyberdata.management.model.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {

}