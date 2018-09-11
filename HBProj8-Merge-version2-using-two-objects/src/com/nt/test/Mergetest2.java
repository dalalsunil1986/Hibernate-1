package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.BrandFactory;
import com.nt.utility.HibernateUtil;

public class Mergetest2 {

	public static void main(String[] args) {
		
		Session ses=null;
		BrandFactory factory=null,factory1=null;
		Transaction tx=null;
		boolean flag=false;
		
		//Get Session 
		
		ses=HibernateUtil.getSession();
		
		try {
		
		tx=ses.beginTransaction(); 
		
		factory=new BrandFactory() ;
		
		factory.setCustMobileNo(67999999L);
		factory.setCustName("Sanka1");
		factory.setCustAddr("A2");
		factory.setRewardPoints(811);
		
		
		
		//merge
		
		ses.save(factory);
		
		factory.setCustAddr("tanu1");
		
		System.out.println("After Save::"+factory);
		
		factory1=new BrandFactory();
		

		factory.setCustMobileNo(67999999L);
		factory.setCustName("S");
		factory.setCustAddr("u");
		
		
		
		ses.update(factory1);
		
		System.out.println("After Update::"+factory1);
		
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
