package com.nt.entity;

import java.io.Serializable;

import lombok.Data;




@SuppressWarnings("serial")

@Data

public class Programmers_Projects implements Serializable {
	
	private PrgmrProjId id;
	
	private String pname;
	
	private String projName;

	
}
