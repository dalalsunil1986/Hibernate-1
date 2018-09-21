package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.Student;
import com.nt.utility.HibernateUtil;

public class GeneratorTest1 {
	
	
	public static void main(String[] args) {
		
		//Bootstrapping Hibernate
		
		Session ses=null;
		Student st=null;
		Transaction tx=null;
		boolean flag=false;
		int idVal=0;
		

		//Get Session 
		
		ses=HibernateUtil.getSession();
		
		try {
		
			//begin Transaction(TX)
		tx=ses.beginTransaction(); 
		
		for(int i=1;i<10;i++){
		
		st=new Student();
		
		st.setSno(1231);
		st.setSname("Sankar"+i);
		st.setSadd("Razole");
		
		if(i==5)
			
			Thread.sleep(30000);
		
		idVal=(int) ses.save(st);
		System.out.println("Generator Id value::"+idVal);
		
		flag=true;
		
		}//for
		
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
