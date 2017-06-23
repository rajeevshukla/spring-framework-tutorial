package com.globallogic.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.globallogic.crud.model.Employee;
import com.globallogic.crud.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping("/employees")
	public List<Employee> getEmployees(){
 		return employeeService.getAllEmployees();
	}
 	
	@RequestMapping("employee/${empId}")
	public Employee findEmployeeById(@PathVariable("empId")Integer empId){
		return employeeService.findEmployeeById(empId);
	}
	
	
}
