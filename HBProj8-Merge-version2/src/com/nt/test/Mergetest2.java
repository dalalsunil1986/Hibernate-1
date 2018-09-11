package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.BrandFactory;
import com.nt.utility.HibernateUtil;

public class Mergetest2 {

	public static void main(String[] args) {
		
		Session ses=null;
		BrandFactory factory=null;
		Transaction tx=null;
		boolean flag=false;
		
		//Get Session 
		
		ses=HibernateUtil.getSession();
		
		try {
		
		tx=ses.beginTransaction(); 
		
		factory=new BrandFactory() ;
		
		factory.setCustMobileNo(8799999L);
		factory.setCustName("Sanka");
		factory.setCustAddr("A");
		factory.setRewardPoints(81);
		
		
		
		//merge
		
		ses.save(factory);
		
		factory.setCustAddr("tanuku1");
		
		System.out.println("After Save::"+factory);
		
		ses.update(factory);
		
		System.out.println("After Update::"+factory);
		
		flag=true;
			
		}//try
		
		catch(HibernateException he) {
			flag=false;
		
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
