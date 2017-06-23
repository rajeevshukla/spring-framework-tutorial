package com.globallogic.crud.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.globallogic.crud.dao.EmployeeCrudDao;
import com.globallogic.crud.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeCrudDao employeDao;
	 
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee>  employeeList  = new ArrayList<>();
		for (Employee employee : employeDao.findAll()) {
			 employeeList.add(employee);
		} 
		return employeeList;
	}

	@Override
	public Employee findEmployeeById(int id) {

		return employeDao.findOne(id);
	}

	@Override
	public Employee employeeByEmail(String emailId) {

		return null;
	}

	@Override
	public void deleteEmployeeById(int empId) {
           
		   employeDao.delete(empId);
		
	}

	@Override
	public void updateEmployee(Employee employee) {

		
	}

	@Override
	public void saveEmployee(Employee employee) {
 
		
	}

	
}
