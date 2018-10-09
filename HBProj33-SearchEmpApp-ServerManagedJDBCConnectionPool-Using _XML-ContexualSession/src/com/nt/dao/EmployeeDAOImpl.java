package com.nt.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Employee;
import com.nt.utility.HibernateUtil;

public class EmployeeDAOImpl implements EmployeeDAO {

	@SuppressWarnings("unused")
	@Override
	public Employee findEmployee(int eno) {
	
		Session ses=null;
		
		Employee emp=null;
		
		Transaction tx=null;
		
		//Get Session 
		try {
		
		ses=HibernateUtil.getSession();
		
		tx=ses.beginTransaction();
		
		System.out.println("Ses object Hashcodde::"+ses.hashCode());
		
		//LoadObject
		
		emp=ses.get(Employee.class,eno);
		
		
		}
		
		catch(HibernateException he) {
			
			throw he;
		}
		catch(Exception e) {
			
			throw e;
		}
		
		return emp;
		
	}

}
