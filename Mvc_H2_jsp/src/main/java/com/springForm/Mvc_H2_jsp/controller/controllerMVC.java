package com.springForm.Mvc_H2_jsp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import com.springForm.Mvc_H2_jsp.controller.model.Employee;

@Controller
public class controllerMVC {
	
	@Autowired  //used to configure EmployeeRepo in this file
	EmployeeRepo repo;  //this is API of JPA, with the help of this we can do CRUD etc, which are present in JPA interface.
	
	@GetMapping(value="/")
	public String getindex() {
		return "index.jsp";
	}
	
	@PostMapping(value="/employeeForm")
	public String addEmployee(Employee data, Model model) {
		
		repo.save(data);
		return "success.jsp";
		//System.out.println("addEmployee method is triggered");
	}
}
