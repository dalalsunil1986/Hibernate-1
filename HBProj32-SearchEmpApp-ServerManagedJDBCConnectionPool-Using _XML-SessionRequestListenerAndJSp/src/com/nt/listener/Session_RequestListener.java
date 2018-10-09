package com.nt.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

import com.nt.utility.HibernateUtil;

@WebListener

public class Session_RequestListener implements ServletRequestListener {
	
	HttpServletRequest hsr=null;
	
	@Override
	public void requestDestroyed(ServletRequestEvent sre) {
		
		System.out.println("Session_RequestListener.requestDestroyed()");
		
		//Get Request Object
		
		hsr=(HttpServletRequest) sre.getServletRequest();
		
		if(hsr.getServletPath().equalsIgnoreCase("/controller")) {
			
			System.out.println("Request to servlet");
		
		
		HibernateUtil.closeSession();
		
		}
	}

}
