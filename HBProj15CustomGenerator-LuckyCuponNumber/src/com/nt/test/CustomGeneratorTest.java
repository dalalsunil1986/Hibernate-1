package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nt.entity.LuckyDrawCupon;
import com.nt.utility.HibernateUtil;

public class CustomGeneratorTest {

	public static void main(String[] args) {

        Session ses=null;
        
        Transaction tx=null;
        
        boolean flag=false;
        
        LuckyDrawCupon cupon=null;
        
        long idVal=0;
        
        //Get Session
        
        ses=HibernateUtil.getSession();
        
        try {
        	
        	tx=ses.beginTransaction();
        	
        	//Save Object
        	
        	cupon=new LuckyDrawCupon();
        	
        	cupon.setCustMobileNumber(9494624217L);
        	
        	cupon.setCustAddrs("razole");
        	
        	cupon.setCustName("Sankar");
        	
        	idVal=(long) ses.save(cupon);
        	
        	flag=true;
        	
        	System.out.println("CustomGeneratorTest::"+idVal);
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
        	
        	if(flag==true) {
        		
        		tx.commit();
        		
        		System.out.println("Object Saved");
        		
        	}
        	
        	else {
        		
        		tx.rollback();
        		
        		System.out.println("Object Not Saved");
        		
        	}
        	
        	//Close Objects
        	
        	HibernateUtil.closeSession(ses);
        	HibernateUtil.closeSessionFactory();
        }
        
        
		

	}

}
