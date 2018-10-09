package com.nt.service;

import com.nt.dao.EmployeeDAO;
import com.nt.dao.EmployeeDAOFactory;
import com.nt.dto.EmployeeDTO;
import com.nt.entity.Employee;

public class EmployeeServiceImpl implements EmployeeService {
	
	EmployeeDAO dao=null;
	
	public EmployeeServiceImpl() {
		

		dao=EmployeeDAOFactory.getInstance();
		
	}

	@Override
	public EmployeeDTO searchEmployee(int eno) {
	
		Employee emp=null;
		
		EmployeeDTO dto=null;
		
		//Get DAO
		
		
		emp=dao.findEmployee(eno);
		
		//Convert Entity object to DAO Class Object
		
		if(emp!=null) {
		
		dto=new EmployeeDTO();
		
		dto.setEid(emp.getEid());
		
		dto.setEname(emp.getEname());
		
		dto.setEmail(emp.getEmail());
		
		dto.setSalary(emp.getSalary());
		
		}
		
		return dto;
	}

}
