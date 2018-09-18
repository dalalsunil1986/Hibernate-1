package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Student;
import com.nt.utility.HibernateUtil;

public class GeneratorTest {
	
	
	public static void main(String[] args) {
		
		//Bootstrapping Hibernate
		
		Session ses=null;
		Student st=null,st1=null;
		Transaction tx=null;
		boolean flag=false;
		int idVal=0,idVal1=0;
		

		//Get Session 
		
		ses=HibernateUtil.getSession();
		
		try {
		
			//begin Transaction(TX)
		tx=ses.beginTransaction(); 
		
		st=new Student();
		
		st.setSno(153);
		st.setSname("Sankar");
		st.setSadd("Razole");
		
		idVal=(int) ses.save(st);
		
		System.out.println("Generator Id value::"+idVal);
		
		
		st1=new Student();
		

		st1.setSno(122);
		st1.setSname("Sankar");
		st1.setSadd("Razole");
		
		idVal1=(int) ses.save(st1);
		
		System.out.println("Generator Id value::"+idVal1);
		
		
		
		flag=true;
		
		}//try
		
		catch(HibernateException he) {
			flag=false;
			
			he.printStackTrace();
		
		}
		
		catch(Exception e) {
			
			e.printStackTrace();
		}
	
		finally {
			
			//commit or rollback Transaction
			
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
		
	}//main method

}//class
