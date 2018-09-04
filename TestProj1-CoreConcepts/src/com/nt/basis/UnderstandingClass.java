package com.nt.basis;

import java.util.Date;

public class UnderstandingClass {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args)throws Exception {
		
		Class c1=null;
		Class c2=null;
		Class c3=null;
		Class c4=null;
		Date d1=null;
	
		//Different Ways creating object for java.lang.Class 
		String s1=new String("hello");
		c1=s1.getClass();
		System.out.println("c1 Class name::"+c1.getClass()+"c1 data::"+c1.toString());
		System.out.println("-------------------------------------------------------");
		
		
		c2=Class.forName("java.util.Date");
		System.out.println("c2 Class name::"+c2.getClass()+"c2 data::"+c2.toString());
		d1=(Date) c2.newInstance();
		System.out.println("d1 Class name::"+d1.getClass()+"d1 data::"+d1.toString());
		System.out.println("-------------------------------------------------------");
		
		c3=Integer.class;
		System.out.println("c3 Class name::"+c3.getClass()+"c3 data::"+c3.toString());
		c4=Test.class;
		System.out.println("c4 Class name::"+c4.getClass()+"c4 data::"+c4.toString());
		System.out.println("-------------------------------------------------------");
	

	}

}
