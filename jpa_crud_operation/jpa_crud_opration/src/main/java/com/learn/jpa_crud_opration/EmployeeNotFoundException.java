package com.learn.jpa_crud_opration;

public class EmployeeNotFoundException extends RuntimeException{
     
	public EmployeeNotFoundException(String msg) {
		super(msg);
	}
}
