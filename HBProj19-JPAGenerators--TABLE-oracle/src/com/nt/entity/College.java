package com.nt.entity;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

import lombok.Data;


@SuppressWarnings("serial")
@Entity

@Data

public class College implements Serializable {
	
	@Id
	
	@TableGenerator(name="gen1",pkColumnName="ID_GEN",
	
	
						pkColumnValue="ID",table="ID_TAB",valueColumnName="ID_val",
										
													initialValue=100,allocationSize=5)		
	
	@GeneratedValue(generator="gen1",strategy=GenerationType.TABLE)
	
	private int  id;
	
	private String name;
	
	private String location;
	
	private int strength;
	
	private String grade;

	
}