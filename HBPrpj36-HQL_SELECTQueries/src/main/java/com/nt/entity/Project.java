package com.nt.entity;

import java.io.Serializable;

import lombok.Data;



@SuppressWarnings("serial")
@Data

public class Project implements Serializable {
	
	private int projId;
	
	private String projName;
	
	private int teamSize;
	
	private String manager;
	
	private String company;
	
	public void  project() {
		
		System.out.println("Project.project()");
		
	}

}
