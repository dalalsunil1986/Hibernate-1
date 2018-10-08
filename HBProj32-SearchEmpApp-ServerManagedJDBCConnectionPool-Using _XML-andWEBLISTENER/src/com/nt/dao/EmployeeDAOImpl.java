package com.nt.dao;

import org.hibernate.Session;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class EmployeeDAOImpl implements EmployeeDAO {

	@Override
	public Employee findEmployee(int eno) {
	
		Session ses=null;
		
		Employee emp=null;
		
		//Get Session 
		
		ses=HibernateUtil.getSession();
		
		//LoadObject
		
		emp=ses.get(Employee.class,eno);
		
		return emp;
	}

}
