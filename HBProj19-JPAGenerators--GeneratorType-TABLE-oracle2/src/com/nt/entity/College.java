package com.nt.entity;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import lombok.Data;


@SuppressWarnings("serial")
@Entity

@Data

public class College implements Serializable {
	
	@Id
	
	
	@GeneratedValue(strategy=GenerationType.TABLE)
	
	private int  id;
	
	private String name;
	
	private String location;
	
	private int strength;
	
	private String grade;

	
}