package com.nt.dao;

public class EmployeeDaoFactory {
	
	public static  EmployeeDao getInstance() {
		
		return new  EmployeeDaoimpl();
	}

}
