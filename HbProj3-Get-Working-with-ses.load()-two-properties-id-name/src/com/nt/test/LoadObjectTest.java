package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nt.entity.InsurencePolicy;

public class LoadObjectTest {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		InsurencePolicy policy=null;
		
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
				
				policy=ses.load(InsurencePolicy.class, 101);
				
				System.out.println(policy.getPolicyId());
				System.out.println(policy.getPolicyName());

				if(policy==null)
					
					System.out.println("\n No Record or object Found::\n");
				
				else
				
				
					System.out.println("\n Record or Object found, Details::\n");
				
					System.out.println(policy.getPolicyId()+"\t"+policy.getPolicyName()+"\t"+policy.getPolicyHolderName()+"\t"+policy.getTenure());
				
			}//try
			
			catch(HibernateException he) {
				
				he.printStackTrace();
				
			}//catch
			
			finally {
				
				//close objects
				
				ses.close();
				
				factory.close();
				
			}//finally
				
		
		
				
	}//main method

}//class
