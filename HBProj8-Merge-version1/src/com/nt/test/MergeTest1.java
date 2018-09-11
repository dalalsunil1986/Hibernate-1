package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.BrandFactory;
import com.nt.utility.HibernateUtil;

public class MergeTest1 {

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
		
		factory.setCustMobileNo(9999999999L);
		factory.setCustName("Sankar1");
		factory.setCustAddr("AP");
		factory.setRewardPoints(8);
		
		flag=true;
		
		//merge
		
		factory=(BrandFactory) ses.merge(factory);
		
		System.out.println("After Merge::"+factory);
			
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
