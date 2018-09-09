package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.BankAccount;
import com.nt.utility.HibernateUtil;

public class UpdateObjectTest2 {

	public static void main(String[] args) {
		
		Session ses=null;
		BankAccount account=null;
		Transaction tx=null;
		boolean flag=false;
		
		//Get Session 
		
		ses=HibernateUtil.getSession();
		
		//Create  Object (approach2)--Load and modify the Object
		
		account=new BankAccount();
		
		account.setAccno(102);
		account.setHolderName("ramu");
		account.setBalance(110);
		account.setType("current");
		
		account=ses.get(BankAccount.class,102);
		
		if(account!=null) {
		
		try {
			
			tx=ses.beginTransaction();
			
			account.setBalance(600);
			
			ses.update(account);
			
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
			System.out.println("Object Updated");
			
		}
		else {
			
			tx.rollback();
			System.out.println("Object is Not Updated");
			
		}
			
			//Close Objects
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally	
		
		}//if
		
		else {
			
			System.out.println("Record Not Found");
		}
		
	
	}//main

}//class
