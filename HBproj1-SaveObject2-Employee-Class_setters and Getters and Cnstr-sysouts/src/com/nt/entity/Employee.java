//entity class,persistence class,model class,BO class,HLO class,domain class,pojo class

package com.nt.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Employee implements Serializable {
	
	//Entities Properties
	
	private int eid;
	
     private String ename;
	
	private String email;
	
	private float salary;

	
	
	//setters and getters
	
	public Employee() {
		
		System.out.println("Employee Constructor");
	}

	public int getEid() {
		
		System.out.println("Employee getterEid");

		
		return eid;
		
	}

	public void setEid(int eid) {
		
		System.out.println("Employee setterEid");
		
		this.eid = eid;
		
	}
	

	public String getEname() {
		
		System.out.println("Employee getterEname");
		
		return ename;
		
	}

	public void setEname(String ename) {
		
		System.out.println("Employee setterEname");
		
		this.ename = ename;
		
	}
	
	

	public String getEmail() {
		
		System.out.println("Employee getterEmail");
		
		return email;
		
	}

	public void setEmail(String email) {
		
		System.out.println("Employee setterEmail");
		
		this.email = email;
		
	}
	
	

	public float getSalary() {
		
		System.out.println("Employee getterSalary");
		
		return salary;
		
	}

	public void setSalary(float salary) {
		
		System.out.println("Employee setterSalary");
		
		this.salary = salary;
		
	}

	

}//class
