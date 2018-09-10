package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.BrandFactory;
import com.nt.utility.HibernateUtil;

public class SaveOrUpdattest1 {

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
		
		factory.setCustMobileNo(999999999);
		factory.setCustName("Sankar");
		factory.setCustAddr("AP");
		factory.setRewardPoints(8);
		
		flag=true;
		
		//saveOrUpdate the Object
		
		ses.saveOrUpdate(factory);
			
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
