package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.EmployeeDTO;
import com.nt.service.EmployeeService;
import com.nt.service.EmployeeServiceFacory;


@SuppressWarnings("serial")
@WebServlet("/controller")
public class MainControllerServlet extends HttpServlet {
	
	EmployeeService service=null;
	
	@Override
	public void init() throws ServletException {
		
		service=EmployeeServiceFacory.getInstance();
		
	}
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		PrintWriter pw=null;
		
		int eno=0;
		
		EmployeeDTO dto=null;
		
		RequestDispatcher rd=null;
		
		//General Settings
		
		pw=res.getWriter();
		
		res.setContentType("text/html");
		
		//Read Form Data
		
		eno=Integer.parseInt(req.getParameter("eno"));
		
		//Use Service
		
		dto=service.searchEmployee(eno);
		
		//Keep DTO Object in request Scope
		
		req.setAttribute("empData",dto);
		
		//Forward Request Show_Emp.jsp
		
		rd=req.getRequestDispatcher("/Show_Emp.jsp");
		
		rd.forward(req, res);
		
		//close 
		
		pw.close();
		
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		doGet(req, res);
	}

}
