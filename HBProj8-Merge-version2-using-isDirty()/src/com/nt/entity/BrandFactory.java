package com.nt.entity;

import java.io.Serializable;

import lombok.Data;

@SuppressWarnings("serial")
@Data

public class BrandFactory implements Serializable {
	
	private long custMobileNo;
	
	private String custName;
	
	private String custAddr;
	
	private int rewardPoints;
	
	public  BrandFactory() {
		
		System.out.println(" BrandFactory::0-prameter constructor");
		
	}

}