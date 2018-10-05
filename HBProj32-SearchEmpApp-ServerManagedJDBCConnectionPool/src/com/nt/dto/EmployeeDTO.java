package com.nt.dto;

import java.io.Serializable;

import lombok.Data;

@SuppressWarnings("serial")

@Data

public class EmployeeDTO implements Serializable {
	
	private int eid;
	
	private String ename;
	
	private String email;
	
	private int salary;

}
