package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.PrgmrProjId;
import com.nt.entity.Programmers_Projects;
import com.nt.utility.HibernateUtil;

public class CompositeIdSaveTest {
	
	public static void main(String[] args) {
		
		Session ses=null;
		
		PrgmrProjId id=null,idVal=null;
		
		Transaction tx=null;
		
		Programmers_Projects info=null;
		
		boolean flag=false;
		
		//Get Session 
		
		ses=HibernateUtil.getSession();
		
		//Prepare Entity Class object
		
		id=new PrgmrProjId();
		
		id.setProjId(1);
		
		id.setPid(11);
		
		info=new Programmers_Projects();
		
		info.setId(id);
		
		info.setPname("Sankar");
		
		info.setProjName("proj1");
		
		try {
			
			tx=ses.beginTransaction();
			
			idVal=(PrgmrProjId)ses.save(info);
			
			System.out.println("Generated ID Value::"+idVal);
			
			flag=true;
			
		}
		
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
				
				System.out.println("Object is Saved with Composite ID");
				
			}
			
			else {
				
				tx.rollback();
				
				System.out.println("Object is not Saved");
				
			}
			//Close Objects
			
			HibernateUtil.closeSession(ses);
			
			HibernateUtil.closeSessionFactory();
		}
		
	}
}


