package com.nt.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import com.nt.entity.Project;
import com.nt.utility.HibernateUtil;


@SuppressWarnings("deprecation")
public class HQLSelectTest {


	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static void main(String[] args) {
		
		
		Session ses=null;
		
		
		Query query=null;
		
		List<Project> list=null;
		
		//Get Session
		
		ses=HibernateUtil.getSession();
		
		try {
			
			//Process Query Object
			
			
			query=ses.createQuery("from Project");//Domain Class
			
			 list=query.list();
			
			//Process the result
			 
			 list.forEach(proj->{
				 
				 System.out.println(proj.getProjId()+"\t"+proj.getProjName()+"\t"+proj.getTeamSize()+"\t"+proj.getManager()+"\t"+proj.getCompany()); 
				 
			 });
			 
		}
			 
			 catch(HibernateException he) {
				 
				 he.printStackTrace();
			 }
			 
			 catch(Exception e) {
				 
				 e.printStackTrace();
				 
			 }
			 
			 finally {
				 
				 HibernateUtil.closeSession(ses);
				 
				 HibernateUtil.closeSessionFactory();
			 }
		}
	}


