package com.nt.generator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class CustomNITIdGenerator implements IdentifierGenerator {
	
	private final String GET_SEQ_VALUE="SELECT NIT_SQL.nextVal from dual ";	
		
	@Override
	
	public Serializable generate(SharedSessionContractImplementor session, Object obj) throws HibernateException {
		
		Connection con=null;
		
		PreparedStatement ps=null;
		
		ResultSet rs=null;
		
		int val=0;
		
		System.out.println("customIdGenerator.generate()");
		
		try {
			
			//Get JDBC Connection object from Hibernate Session 
			
			con=session.connection();
			
			//Create PreparedStatement Object
			
			ps=con.prepareStatement(GET_SEQ_VALUE);
			
			//Execute the Query
			
			rs=ps.executeQuery();
			
			//Get Sequence value
			
			rs.next();
			
			val=rs.getInt(1);
			
			
			
			
		}//try
		
		catch(SQLException se) {
			
			System.out.println("Internal Problem in generating ID value::"+se.getMessage());
			
		}
		
		catch(Exception e) {
			
			System.out.println("Unknown Problem in generating ID value::"+e.getMessage());
			
		}
		
		if(val<=9)
		
		return "NIT000"+val;
		
		else if(val<=99)
			
			return "NIT00"+val;
		
       else if(val<=999)
			
			return "NIT0"+val;
       else
    	   
    	   return "NIT"+val;


	}

}
