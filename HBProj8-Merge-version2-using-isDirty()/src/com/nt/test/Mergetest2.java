package com.nt.test;


import org.hibernate.Session;


import com.nt.entity.BrandFactory;
import com.nt.utility.HibernateUtil;

public class Mergetest2 {

	public static void main(String[] args) {
		
		Session ses=null;
		BrandFactory factory=null;
		
		
		//Get Session 
		
		ses=HibernateUtil.getSession();
		
          factory=ses.get(BrandFactory.class,999999L);
		
		System.out.println(factory);
		
		System.out.println("isDirty()::?"+ses.isDirty());
		
		factory.setCustAddr("a");
		
		System.out.println("isDirty()::"+ses.isDirty());
		
		//Close Objects
		HibernateUtil.closeSession(ses);
		HibernateUtil.closeSessionFactory();
		
		
	}//main

}//class
