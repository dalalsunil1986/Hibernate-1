package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.College;
import com.nt.utility.HibernateUtil;

public class AnnoHBSaveTest {

	public static void main(String[] args) {
		
		Session ses=null;
		
		Transaction tx=null;
		
		College clg=null;
		
		boolean flag=false;
		
		int idVal=0;
		
		//Get Session 
		
		ses=HibernateUtil.getSession();
		
		try {
			
			tx=ses.beginTransaction();
			
			clg=new College();
			
			//here every compilation change id and name
			
			clg.setId(1187);
			
			clg.setName("San2133");
			
			clg.setLocation("razole");
			
			clg.setStrength(200);
			
			clg.setGrade("A");
			
			idVal=(int) ses.save(clg);
			
			System.out.println("Generated ID value::"+idVal);
			
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
				
				System.out.println("Object is Saved");
				
			}
			
			else {
				
				tx.rollback();
				
				System.out.println("Object is not Saved");
				
			}
			
			//close Objects
			
			HibernateUtil.closeSession(ses);
			
			HibernateUtil.closeSessionFactory();
			
		}
		

	}

}
