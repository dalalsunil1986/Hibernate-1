package com.nt.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class oracle_HibernateUtil {
	
	private static SessionFactory factory;
	
	static {
		
		Configuration cfg=null;
		
		//create configuration Object
		
		cfg=new Configuration();
		
		cfg.configure("/com/nt/cfgs/oracle_hibernate.cfg.xml");
		
		//Create SessionFactory Object
		
		factory=cfg.buildSessionFactory();
	}
	
	public static Session getSession() {
		
		Session ses=null;
		
		if(factory!=null)
			
			ses=factory.openSession();
		
		return ses;
		
	}
	
	public static void closeSession(Session ses) {
		
		if(ses!=null)
			
			ses.close();
	}
	
	public static void closeSessionFactory() {
		
		if(factory!=null)
			
			factory.close();
	}

}//class
