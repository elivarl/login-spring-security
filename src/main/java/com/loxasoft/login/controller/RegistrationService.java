package com.loxasoft.login.controller;

import org.springframework.stereotype.Service;

import com.loxasoft.login.model.AppUser;
import com.loxasoft.login.model.AppUserRole;
import com.loxasoft.login.model.AppUserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RegistrationService {
	
	private final AppUserService appUserService;
	private final EmailValidator emailValidator;
	
	public String register(RegistrationRequest request) {
		boolean isValidEmail= emailValidator.test(request.getEmail());
		if (!isValidEmail) {
			throw new IllegalStateException("email not valid");
		}
		return appUserService.singUpUser(new AppUser(request.getFirstName(), request.getLastName(), request.getEmail(), request.getPassword(), AppUserRole.USER));
	}
}
