package com.nt.entity;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.Id;


import org.hibernate.annotations.Type;


@SuppressWarnings("serial")
@Entity

public class College implements Serializable {
	
	private int  id;
	
	private String name;
	
	private String location;
	
	private int strength;
	
	private String grade;

	
	
	@Id
	
	
	@Type(type="int")
	
	public int getId() {
		
		return id;
	}

	public void setId(int id) {
		
		this.id = id;
	}
	
	
	@Type(type="string")
	
	public String getName() {
		
		return name;
	}

	public void setName(String name) {
		
		this.name = name;
		
	}

	
	
	@Type(type="string")
	
	public String getLocation() {
		
		return location;
	}

	public void setLocation(String location) {
		
		this.location = location;
		
	}
	
	
     
	@Type(type="int")

	public int getStrength() {
    	 
		return strength;
	}

	public void setStrength(int strength) {
		
		this.strength = strength;
	}

	
  
	@Type(type="string")
	
	public String getGrade() {
		
		return grade;
	}

	public void setGrade(String grade) {
		
		this.grade = grade;
	}

}
