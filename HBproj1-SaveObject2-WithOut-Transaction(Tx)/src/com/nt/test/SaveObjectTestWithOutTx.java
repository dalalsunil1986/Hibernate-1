package com.nt.test;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Employee;

public class SaveObjectTestWithOutTx {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		//Bootstrapping Hibernate
		
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Employee emp=null;
		Transaction tx=null;
		boolean flag=false;
		
		
		cfg=new Configuration();
		
		//Hold hibernate configuration(cfg) file and Hibernate mapping file
		
		cfg=cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
		
		//Build SessionFactory Object
		
		factory=cfg.buildSessionFactory();
		
		//create Session
		
		ses=factory.openSession();
		
		//create Entity class Object
		
		emp=new Employee();
		
		emp.setEid(110);
		emp.setEname("sankar");
		emp.setEmail("karrasankar158@gmail.com");
		emp.setSalary(1500);
		
		//flush the Session
		
		ses.flush();//these is not allowed in 5.x,allowed in 4.x--->ses.flush()is not recommended
		
		
	

			//Close Objects
			
			ses.close();
			factory.close();
			
	
	
	}//main method

}//class
