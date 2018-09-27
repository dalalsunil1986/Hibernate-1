package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


import com.nt.entity.StockInfo;
import com.nt.utility.HibernateUtil;

public class LoadObjectTest {
	
	public static void main(String[] args) {
		
		Session ses=null;
		
		Transaction tx=null;
		
		 StockInfo info=null;
		
		
		boolean flag=false;
		
		//get Session
		
		ses=HibernateUtil.getSession();
		

		//Load and Modify Object
		
		info=ses.get(StockInfo.class,81);
		
		if(info==null){
			
			System.out.println("Object is not Found");
			
			return;
			
		}
		
		try {
			
			tx=ses.beginTransaction();
			
			
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
				
				System.out.println("Object is Saved::"+info.getListingTime());
				
			}
			
			else {
				
				tx.rollback();
				
				System.out.println("Object is not Saved::");
				
			}
			
			//Close Objects
			
			HibernateUtil.closeSession(ses);
			
			HibernateUtil.closeSessionFactory();
		}
		
	}

}
