package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.InsurencePolicy;

public class FirstLevelCacheTest1 {

	public static void main(String[] args) {
		
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		InsurencePolicy policy=null;
		Transaction tx=null;
		boolean flag=false;
		
		//Bootstrapping Hibernate
		
		cfg=new Configuration();
		
	//Hold hibernate configuration(cfg) file and Hibernate mapping file
		
		//read Cfg ,mapping files
		
		
		cfg=cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
		
		//Build SessionFactory Object
		
		//create SessionFactory Object
		
				factory=cfg.buildSessionFactory();
				
				//create Session
				
				ses=factory.openSession();
			try {
				//Get Object
				
				policy=ses.get(InsurencePolicy.class, 101);
				
				
				if(policy==null) {
					
					System.out.println("\n No Record or object Found::\n");
				
				return;
				
				}
				else {
					
					tx=ses.beginTransaction();
					
					policy.setTenure(88);
					
					ses.update(policy);
					
					policy.setPolicyHolderName("puja");
					
					ses.update(policy);
					
					flag=true;
					
				}
			}//try
			
			catch(HibernateException he) {
				
				flag=false;
				
				he.printStackTrace();
				
			}//catch
			
			catch(Exception e) {
				
				flag=false;
				
				e.printStackTrace();
			}
			
			finally {
				
				if(flag) {
					
					tx.commit();
					
					System.out.println("Object is Updated"); 
				}
				
				//close objects
				
				ses.close();
				
				factory.close();
				
			}//finally
				
		
		
				
	}//main method

}//class
