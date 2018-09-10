package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;


import com.nt.entity.BankAccount;
import com.nt.utility.HibernateUtil;

public class BankAccountTableRowToObjectSynchronization {

	public static void main(String[] args) {
		
		Session ses=null;
		BankAccount account=null;
		
		
		//Get Session 
		
		ses=HibernateUtil.getSession();
		
		//Create  Object (approach3)--Without Calling ses.update(),using Synchronization
		
		account=new BankAccount();
		try {
		
		account=ses.get(BankAccount.class,101);
		
		System.out.println(account);
		
		Thread.sleep(30000);//Modify 101 record from Db table during this sleep period 
		
		ses.refresh(account);
		
		System.out.println(account);
			
		}//try
		
		catch(InterruptedException ie) {
			
			ie.printStackTrace();
		}
		
		
		catch(HibernateException he) {
			
			he.printStackTrace();
		}
		
		catch(Exception e) {
			
			e.printStackTrace();
			
		}
		
		
		finally {
			
			
			//Close Objects
			HibernateUtil.closeSession(ses);
			HibernateUtil.closeSessionFactory();
		}//finally	
		
		
	}//main

}//class
