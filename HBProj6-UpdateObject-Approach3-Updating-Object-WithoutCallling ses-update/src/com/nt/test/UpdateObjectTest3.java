package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.BankAccount;
import com.nt.utility.HibernateUtil;

public class UpdateObjectTest3 {

	public static void main(String[] args) {
		
		Session ses=null;
		BankAccount account=null;
		Transaction tx=null;
		boolean flag=false;
		
		//Get Session 
		
		ses=HibernateUtil.getSession();
		
		//Create  Object (approach2)--Load and modify the Object
		
		account=new BankAccount();
		
		account.setAccno(103);
		account.setHolderName("vasu");
		account.setBalance(1100);
		account.setType("current");
		
		account=ses.get(BankAccount.class,103);
		
		if(account!=null) {
		
		try {
			
			tx=ses.beginTransaction();
			
			account.setBalance(6000);
			
			
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
