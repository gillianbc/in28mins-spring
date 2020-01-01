package com.gillianbc.jee.business;

import org.springframework.stereotype.Service;

@Service
public class UserValidationService {
	public boolean isUserValid(String name, String password) {
		if (name.equals("gillian") && password.equals("gillian"))
			return true;
		return false;
	}
}
