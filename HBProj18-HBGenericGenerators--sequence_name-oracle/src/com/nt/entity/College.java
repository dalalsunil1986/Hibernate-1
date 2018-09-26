package com.nt.entity;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.Data;


@SuppressWarnings("serial")
@Entity

@Data

public class College implements Serializable {
	
	@Id
	
	@GenericGenerator(name="gen1",strategy="sequence", parameters=@Parameter(name="sequence_name", value = "clg_seq"))
	
	//create sequence clg_seq start with 100 increment by 1;
	
	@GeneratedValue(generator="gen1")
	
	private int  id;
	
	private String name;
	
	private String location;
	
	private int strength;
	
	private String grade;

	
}