package com.nt.test;


import org.hibernate.Session;


import com.nt.entity.PrgmrProjId;
import com.nt.entity.Programmers_Projects;
import com.nt.utility.HibernateUtil;

public class CompositeIdLoadTest {
	
	public static void main(String[] args) {
		
		Session ses=null;
		
		PrgmrProjId id=null;
		
		
		Programmers_Projects info=null;
		
		//Get Session 
		
		ses=HibernateUtil.getSession();
		
		//Prepare Entity Class object
		
		id=new PrgmrProjId();
		
		id.setProjId(1);
		
		id.setPid(11);
		
		
		try {
			
			//Get/Load the Object
			
			info=ses.get(Programmers_Projects.class,id);
			
			
			System.out.println(info);
			
			
		}
		
      
		
		finally {
			
			
				
			}
			//Close Objects
			
			HibernateUtil.closeSession(ses);
			
			HibernateUtil.closeSessionFactory();
		}
		
	}



