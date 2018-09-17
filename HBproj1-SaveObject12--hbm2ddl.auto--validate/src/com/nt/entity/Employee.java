//entity class,persistence class,model class,BO class,HLO class,domain class,pojo class

package com.nt.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Employee implements Serializable {
	
	//Entities Properties
	
	private int eid;
	
     private String ename;
	
	private String email;
	
	private int salary;

	
	
	//setters and getters
	
	public int getEid() {
		
		return eid;
		
	}

	public void setEid(int eid) {
		
		this.eid = eid;
		
	}
	

	public String getEname() {
		
		return ename;
		
	}

	public void setEname(String ename) {
		
		this.ename = ename;
		
	}
	
	

	public String getEmail() {
		
		return email;
		
	}

	public void setEmail(String email) {
		
		this.email = email;
		
	}
	
	

	public int getSalary() {
		
		return salary;
		
	}

	public void setSalary(int salary) {
		
		this.salary = salary;
		
	}

	

}//class
