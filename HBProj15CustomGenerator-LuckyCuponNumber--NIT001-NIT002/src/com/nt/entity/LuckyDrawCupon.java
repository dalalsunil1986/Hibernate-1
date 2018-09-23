package com.nt.entity;

import java.io.Serializable;

import lombok.Data;


@SuppressWarnings("serial")
@Data

public class LuckyDrawCupon implements Serializable {
	
	private String cuponNumber;
	
	private String custName;
	
	private long custMobileNumber;
	
	private String custAddrs;
	

}
