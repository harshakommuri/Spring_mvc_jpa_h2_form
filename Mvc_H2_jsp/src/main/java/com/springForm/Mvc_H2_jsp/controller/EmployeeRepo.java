package com.springForm.Mvc_H2_jsp.controller;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springForm.Mvc_H2_jsp.controller.model.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer>{

	
}
