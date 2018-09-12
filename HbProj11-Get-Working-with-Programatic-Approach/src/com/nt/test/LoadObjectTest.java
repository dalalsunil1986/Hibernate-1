package com.nt.test;

import java.lang.reflect.Method;

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
		
		//Specify HB Properties
		
		cfg.setProperty("hibernate.connection.driver-class","oracle.jdbc.driver.");
		
		cfg.setProperty("hibernate.connection.url", "jdbc:oracle:thin:@localhost:1521:ORCL");
		
		cfg.setProperty("hibernate.connection.username","scott");
		
		cfg.setProperty("hibernate.connection.password","tiger");
		
		
		cfg.setProperty("hibernate.dialect", "org.hibernate.dialect.Oracle10gDialect");
		
		cfg.setProperty("hibernate.show-sql","true");
		
		cfg.setProperty("hibernate.format_sql","true");
		
		cfg.setProperty("hibernate.hbm2ddl.auto","update");
		
		//Add mapping File
		
		cfg.addFile("src/com/nt/entity/InsurencePolicy.hbm.xml");
		
		//Build SessionFactory Object
		
		//create SessionFactory Object
		
				factory=cfg.buildSessionFactory();
				
				//create Session
				
				ses=factory.openSession();
			try {
				//Get Object
				
				policy=ses.load(InsurencePolicy.class, 101);
				
				Method methods[]=policy.getClass().getDeclaredMethods();
				
				for(Method m:methods) {
					
					System.out.println(m.getName());
				}
				

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
