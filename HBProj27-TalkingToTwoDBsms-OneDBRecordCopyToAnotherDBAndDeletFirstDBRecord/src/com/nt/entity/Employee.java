package com.nt.entity;

import java.io.Serializable;

import lombok.Data;

@SuppressWarnings("serial")
@Data

public class Employee implements Serializable {

	private int eid;
	
	private String ename;
	
	private String email;
	
	private int salary;
	
}
