package com.huyvu.validator.impl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapperImpl;

import com.huyvu.validator.FieldsValueMatch;

public class FieldsValueMatchValidator 
implements ConstraintValidator<FieldsValueMatch, Object> {

  private String field;
  private String fieldMatch;

  public void initialize(FieldsValueMatch constraintAnnotation) {
      this.field = constraintAnnotation.field();
      this.fieldMatch = constraintAnnotation.fieldMatch();
  }

  public boolean isValid(Object value, 
    ConstraintValidatorContext context) {

      Object fieldValue = new BeanWrapperImpl(value)
        .getPropertyValue(field);
      Object fieldMatchValue = new BeanWrapperImpl(value)
        .getPropertyValue(fieldMatch);
      
      if (fieldValue != null) {
          return fieldValue.equals(fieldMatchValue);
      } else {
          return fieldMatchValue == null;
      }
  }
}