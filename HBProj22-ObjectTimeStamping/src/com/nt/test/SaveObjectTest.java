package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.StockInfo;
import com.nt.utility.HibernateUtil;

public class SaveObjectTest {
	
	public static void main(String[] args) {
		
		Session ses=null;
		
		Transaction tx=null;
		
		 StockInfo info=null;
		
		int idVal=0;
		
		boolean flag=false;
		
		//get Session
		
		ses=HibernateUtil.getSession();
		
		//Save Object
		
		try {
			
			tx=ses.beginTransaction();
			
			//Prepare Object
			
			info=new StockInfo();
			
			info.setStockName("SankarStock");
			
			info.setCompany("PrbSltin");
			
			info.setPrice(9000);
			
			//Save Object
			
			idVal=(int) ses.save(info);
			
			System.out.println("Generated Id Value::"+idVal);
			
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
				
				System.out.println("Object is Saved::");
				
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
