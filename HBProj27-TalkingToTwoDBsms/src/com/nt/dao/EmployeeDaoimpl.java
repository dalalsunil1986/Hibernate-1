package com.nt.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Employee;
import com.nt.utility.mysql_HibernateUtil;
import com.nt.utility.oracle_HibernateUtil;

public class EmployeeDaoimpl implements EmployeeDao {

	@Override
	public void transferEmployee(int eno) {
		
		Session oracleSes=null;
		
		Session mysqlSes=null;
		
		Employee emp=null;
		
		Transaction tx=null;
		
		boolean flag=false;
		
		
		//get Session Objects
		
		oracleSes=oracle_HibernateUtil.getSession();
		
		mysqlSes=mysql_HibernateUtil.getSession();
		
		//Load Object from oracle
		
		emp=oracleSes.get(Employee.class,eno);
		
		//Save Object into Mysql
		
		if(emp==null) {
			
			System.out.println("Object is not Found");
			
			return;
		}
		
		try {
			
			tx=mysqlSes.beginTransaction();
			
			mysqlSes.save(emp);
			
			flag=true;
			
		}//try
		
		catch(HibernateException he) {
			
			flag=false;
			
			he.printStackTrace();
		}
		
		catch(Exception e) {
			
			flag=false;
			
			e.printStackTrace();
		}
		
		finally {
			
			if(flag) {
				
				tx.commit();
				
				System.out.println("Object is Copied");
			}
			
			else {
				
				tx.rollback();
				
				System.out.println("Object is not  Copied");
			}
			
			//Close Objects
			
			oracle_HibernateUtil.closeSession(oracleSes);
			
		    mysql_HibernateUtil.closeSession(mysqlSes);
		}//Finally

	}//method

}//class
