package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;


import com.nt.entity.College;
import com.nt.utility.HibernateUtil;

public class AnnoHBSaveTest {

	public static void main(String[] args) {
		
		Session ses=null;
		
		College clg=null;
		
		
		//Get Session 
		
		ses=HibernateUtil.getSession();
		
		try {
			
			clg=ses.get(College.class,158);
			
			System.out.println(clg);
			
		}//try
		
		catch(HibernateException he) {
			
			
			he.printStackTrace();
		}
		
		catch(Exception e) {
			
			
			e.printStackTrace();
		}
		
		
			//close Objects
			
			HibernateUtil.closeSession(ses);
			
			HibernateUtil.closeSessionFactory();
			
		}
		

	}


