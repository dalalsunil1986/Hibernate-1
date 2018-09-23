package com.nt.generator;

import java.io.Serializable;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomCuponIdGenerator implements IdentifierGenerator {
	
	

	public CustomCuponIdGenerator() {
		
		System.out.println("customIdGenerator.customIdGenerator()");
		
	}

	@Override
	
	public Serializable generate(SharedSessionContractImplementor session, Object obj) throws HibernateException {
		
		System.out.println("customIdGenerator.generate()");
		
		Random rad=null;
		
		int val=0;
		
		//Generate Random Number
		
		rad=new Random();
		
		val=rad.nextInt(1000);
		
		return val;
	}

}
