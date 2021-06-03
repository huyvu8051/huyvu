package com.huyvu.validator.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.huyvu.validator.ContactNumberConstraint;

public class ContactNumberValidator implements ConstraintValidator<ContactNumberConstraint, String>{

	@Override
	public void initialize(ContactNumberConstraint constraintAnnotation) {
		
	}
	
	@Override
	public boolean isValid(String contactField, ConstraintValidatorContext context) {
		return contactField != null && contactField.matches("[0-9]{9,11}");
	}

}
