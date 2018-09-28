package com.nt.entity;

import java.io.Serializable;


import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;




@SuppressWarnings("serial")

@Data

@Entity


@Table(name="PROGRAMMERS_PROJECTS1")

public class Programmers_Projects implements Serializable {
	
	@EmbeddedId
	
	private PrgmrProjId id;
	
	private String pname;
	
	private String projName;

	
}
