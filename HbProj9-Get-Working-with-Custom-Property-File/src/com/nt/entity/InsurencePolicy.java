package com.nt.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class InsurencePolicy implements Serializable {

	private int policyId;
	private String policyName;
	private String policyHolderName;
	private int tenure;
	
	public InsurencePolicy() {
		
		System.out.println("InsurencePolicy.InsurencePolicy()::0-parameter constructor");
		
	}

	public int getPolicyId() {
		
		System.out.println("InsurencePolicy.getPolicyId()");
		
		return policyId;
		
	}

	public void setPolicyId(int policyId) {
		
		System.out.println("InsurencePolicy.setPolicyId()");
		
		this.policyId = policyId;
		
	}

	public String getPolicyName() {
		
		System.out.println("InsurencePolicy.getPolicyName()");
		
		return policyName;
		
	}

	public void setPolicyName(String policyName) {
		
		System.out.println("InsurencePolicy.setPolicyName()");
		
		this.policyName = policyName;
		
	}

	public String getPolicyHolderName() {
		
		System.out.println("InsurencePolicy.getPolicyHolderName()");
		
		return policyHolderName;
		
	}

	public void setPolicyHolderName(String policyHolderName) {
		
		System.out.println("InsurencePolicy.setPolicyHolderName()");
		
		this.policyHolderName = policyHolderName;
		
	}

	public int getTenure() {
		
		System.out.println("InsurencePolicy.getTenure()");
		return tenure;
		
	}

	public void setTenure(int tenure) {
		
		System.out.println("InsurencePolicy.setTenure()");
		
		this.tenure = tenure;
		
	}
	
	
	

}//class
