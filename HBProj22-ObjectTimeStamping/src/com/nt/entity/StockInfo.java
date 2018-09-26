package com.nt.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import lombok.Data;


@SuppressWarnings("serial")
@Data

public class StockInfo implements Serializable {

	
	private int stockId;
	
	private String StockName;
	
	private String company;
	
	private int price;
	
	private Timestamp lastUpdated;
}
