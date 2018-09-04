package com.nt.basics;

import java.lang.reflect.Constructor;
import java.util.Date;

public class NewInstanceTest {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args)throws Exception {
		
	Class c=null;
	Date d1=null;
	Date d2=null;
	Constructor cons=null;
	
	//load class
	c=Class.forName(args[0]);
	
	//Create object of loaded using o-parameter  Constructor.
	d1=(Date) c.newInstance();
	
	//Create object of loaded using 3-parameter  Constructor.
	cons=c.getDeclaredConstructors()[5];
	d2=(Date)cons.newInstance(96,01,01);
	System.out.println("d1=="+d1+"d2=="+d2);
	
	}//main

}//class
