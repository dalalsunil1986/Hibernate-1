package com.nt.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.nt.entity.Employee;

public class SaveObjectTest {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		//Bootstrapping Hibernate
		
		Configuration cfg=null;
		SessionFactory factory=null;
		Session ses=null;
		Employee emp=null,emp1=null;
		Transaction tx=null;
		boolean flag=false;
		
		
		cfg=new Configuration();
		
		//Hold hibernate configuration(cfg) file and Hibernate mapping file
		
		cfg=cfg.configure("/com/nt/cfgs/hibernate.cfg.xml");
		
		//Build SessionFactory Object
		
		factory=cfg.buildSessionFactory();
		
		//create Session
		
		ses=factory.openSession();
		
		//create Entity class Object emp
		
		emp=new Employee();
		
		emp.setEid(27);
		emp.setEname("sankar");
		emp.setEmail("karrasankar158@gmail.com");
		emp.setSalary(1500);
		
		//create Entity class Object emp1
		
				emp1=new Employee();
				
				emp1.setEid(28);
				emp1.setEname("sankar");
				emp1.setEmail("karrasankar158@gmail.com");
				emp1.setSalary(1500);
		
		//Save Object
		
		try {
			
			//Begin Transaction(TX)
			
			tx=ses.beginTransaction();//Begin TX by calling con.setAutoCommit(false);
			
			ses.save(emp);
			
			ses.save(emp1);
			
			flag=true;
			
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
			
			if(flag=true) {
				
				tx.commit();//commits Transaction(TX) by calling con.commit();
				System.out.println("Object Saved / Record is Inserted");
			}
			else {
				
				tx.rollback();// rollback Transaction(TX) by calling con.rollback();
				System.out.println("Object not Saved / Record is not Inserted");
			}
			

			//Close Objects
			
			ses.close();
			factory.close();
			
		}//finally
	
	}//main method

}//class
