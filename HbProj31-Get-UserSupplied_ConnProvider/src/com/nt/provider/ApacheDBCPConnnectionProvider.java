package com.nt.provider;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.engine.jdbc.connections.internal.UserSuppliedConnectionProviderImpl;

@SuppressWarnings("serial")
public class ApacheDBCPConnnectionProvider extends UserSuppliedConnectionProviderImpl {
	
	 private BasicDataSource bds=null;
	 
	 private Connection con=null;
	
	
	public ApacheDBCPConnnectionProvider() {
		
		bds=new BasicDataSource();
		
		bds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		
		bds.setUrl("jdbc:oracle:thin:@localhost:1521:ORCL");
		
		bds.setUsername("scott");
		
		bds.setPassword("tiger");
		
	}

	
	//GET JDBC Connection Object from JDBC ConnectionPool
	
	
	@Override
	public Connection getConnection() throws SQLException {
		
		System.out.println("ApacheDBCPConnnectionProvider.getConnection()");
		
		con=bds.getConnection();
		
		return con;
	}
	
	@Override
	public void closeConnection(Connection conn) throws SQLException {
		
		System.out.println("ApacheDBCPConnnectionProvider.closeConnection()");
		
		conn.close();
	}

}
