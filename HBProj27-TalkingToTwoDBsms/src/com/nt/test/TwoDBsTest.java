package com.nt.test;

import com.nt.dao.EmployeeDao;
import com.nt.dao.EmployeeDaoFactory;
import com.nt.utility.mysql_HibernateUtil;
import com.nt.utility.oracle_HibernateUtil;

public class TwoDBsTest {

	public static void main(String[] args) {
		
		
		EmployeeDao dao=null;
		
		//Get Dao
		
		dao=EmployeeDaoFactory.getInstance();
		
		//Invoke method
		
		dao.transferEmployee(102);
		
		//Close Objects
		
		oracle_HibernateUtil.closeSessionFactory();

		mysql_HibernateUtil.closeSessionFactory();
		
	}//main

}//class
