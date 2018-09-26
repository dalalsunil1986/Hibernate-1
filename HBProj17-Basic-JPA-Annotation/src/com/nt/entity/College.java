package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Type;


@SuppressWarnings("serial")
@Entity

@Table(name="COLLEGE")

public class College implements Serializable {
	
	private int  id;
	
	private String name;
	
	private String location;
	
	private int strength;
	
	private String grade;

	
	
	@Id
	@Column(name="ID",length=10)
	
	@Type(type="int")
	
	public int getId() {
		
		return id;
	}

	public void setId(int id) {
		
		this.id = id;
	}
	
	
	@Column(name="NAME",unique=true,length=20,nullable=false)
	
	@Type(type="string")
	
	public String getName() {
		
		return name;
	}

	public void setName(String name) {
		
		this.name = name;
		
	}

	
	@Column(name="LOCATION",length=20)
	
	@Type(type="string")
	
	public String getLocation() {
		
		return location;
	}

	public void setLocation(String location) {
		
		this.location = location;
		
	}
	
	
     @Column(name="STRENGTH",length=10)
	
	@Type(type="int")

	public int getStrength() {
    	 
		return strength;
	}

	public void setStrength(int strength) {
		
		this.strength = strength;
	}

	
    @Column(name="grade",length=5)
	
	@Type(type="string")
	
	public String getGrade() {
		
		return grade;
	}

	public void setGrade(String grade) {
		
		this.grade = grade;
	}

}
