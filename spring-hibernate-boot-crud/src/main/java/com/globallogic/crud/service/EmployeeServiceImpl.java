package com.globallogic.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.globallogic.crud.dao.EmployeeCrudDao;
import com.globallogic.crud.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeCrudDao employeDao;
	 
	@Override
	public List<Employee> getAllEmployees() {
		
		return null;
	}

	@Override
	public Employee findEmployeeById(int Id) {

		return null;
	}

	@Override
	public Employee employeeByEmail(String emailId) {

		return null;
	}

	@Override
	public void deleteEmployeeById(int empId) {

		
	}

	@Override
	public void updateEmployee(Employee employee) {

		
	}

	@Override
	public void saveEmployee(Employee employee) {

		
	}

	
}
