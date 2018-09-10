package com.nt.entity;

import java.io.Serializable;

import lombok.Data;

@SuppressWarnings("serial")
@Data

public class BankAccount implements Serializable {
	
	private int accno;
	
	private String holderName;
	
	private float balance;
	
	private String type;

}