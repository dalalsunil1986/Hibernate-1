package com.nt.entity;

import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


import org.hibernate.annotations.GenericGenerator;


import lombok.Data;


@SuppressWarnings("serial")
@Entity

@Data

public class College implements Serializable {
	
	@Id
	
	@GenericGenerator(name="gen1",strategy="identity")
	
	@GeneratedValue(generator="gen1")
	
	private int  id;
	
	private String name;
	
	private String location;
	
	private int strength;
	
	private String grade;

	
}