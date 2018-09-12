package com.nt.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


import java.lang.reflect.Method;
import java.util.Properties;

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
		
		FileInputStream is=null;
		Properties props=null;
		try {
		//Load hb.properties file info java.util.properties class Object
		is=new FileInputStream("src/com/nt/commons/hb.properties");
		
		props=new Properties();
		props.load(is);
		
		}
		catch(FileNotFoundException fnf) {
			
			fnf.printStackTrace();
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		
		//Bootstrapping Hibernate
		
		cfg=new Configuration();
		
		//Specify hibernate Properties
		
		cfg.setProperties(props);
		
	//Hold hibernate configuration(cfg) file and Hibernate mapping file
		
		//read Cfg ,mapping files
		
		
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
