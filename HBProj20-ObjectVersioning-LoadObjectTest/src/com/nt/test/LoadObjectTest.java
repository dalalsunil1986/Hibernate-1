package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.MNCustomer;
import com.nt.utility.HibernateUtil;

public class LoadObjectTest {
	
	public static void main(String[] args) {
		
		Session ses=null;
		
		Transaction tx=null;
		
		MNCustomer cust=null;
		
		
		boolean flag=false;
		
		//get Session
		
		ses=HibernateUtil.getSession();
		
		//Load and Modify Object
		
		cust=ses.get(MNCustomer.class,61);
		
		if(cust==null){
			
			System.out.println("Object is not Found");
			
			return;
			
		}
		
		try {
			
			tx=ses.beginTransaction();
			
			//Prepare Object
			
			//Modify the Object
			
			cust.setCallerTune("sheelaki jawani");
			
			
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
			
				System.out.println("Object is Upated for::"+cust.getTuneChangeCount()+"times");
				
			}
			
			else {
				
				tx.rollback();
				
				System.out.println("Object is not Updated::");
				
			}
			
			//Close Objects
			
			HibernateUtil.closeSession(ses);
			
			HibernateUtil.closeSessionFactory();
		}
		
	}

}
