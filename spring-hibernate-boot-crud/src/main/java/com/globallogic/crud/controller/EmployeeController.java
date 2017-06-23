package com.globallogic.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.globallogic.crud.model.Employee;
import com.globallogic.crud.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping(name="/employees")
	@ResponseBody
	public List<Employee> getEmployees(){
		System.out.println(employeeService.getAllEmployees());
		System.out.println("inside get employees");
 		return employeeService.getAllEmployees();
	}
 	
	@RequestMapping("employee/{empId}")
	
	public Employee findEmployeeById(@PathVariable("empId")Integer empId){
		return employeeService.findEmployeeById(empId);
	}
	
	
	public ResponseEntity<Boolean> addEmployee(@RequestBody Employee employee){
		
		return  new ResponseEntity<Boolean>(HttpStatus.OK);
	}
	
	
}
