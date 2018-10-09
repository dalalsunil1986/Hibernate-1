package com.nt.service;

public class EmployeeServiceFacory {
	
	public static EmployeeService getInstance() {
	
	return new EmployeeServiceImpl();
	
	}
}
