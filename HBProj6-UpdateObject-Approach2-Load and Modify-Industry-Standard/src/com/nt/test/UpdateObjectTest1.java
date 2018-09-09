package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.BankAccount;
import com.nt.utility.HibernateUtil;

public class UpdateObjectTest1 {

	public static void main(String[] args) {
		
		Session ses=null;
		BankAccount account=null;
		Transaction tx=null;
		boolean flag=false;
		
		//Get Session 
		
		ses=HibernateUtil.getSession();
		
		//Create  Object (approach1)-- Directly Update the Object
		
		account=new BankAccount();
		
		account.setAccno(101);
		account.setHolderName("Sankar");
		account.setBalance(1110);
		account.setType("savings");
		
		try {
			
			tx=ses.beginTransaction();
			
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
		
	
	}//main

}//class
