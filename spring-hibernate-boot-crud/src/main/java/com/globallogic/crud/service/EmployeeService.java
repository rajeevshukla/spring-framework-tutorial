package com.globallogic.crud.service;

import java.util.List;

import com.globallogic.crud.model.Employee;

public interface EmployeeService {
	public List<Employee> getAllEmployees();

	public Employee findEmployeeById(int Id);

	public Employee employeeByEmail(String emailId);

	public void deleteEmployeeById(int empId);

	public void updateEmployee(Employee employee);

	public void saveEmployee(Employee employee);
}
