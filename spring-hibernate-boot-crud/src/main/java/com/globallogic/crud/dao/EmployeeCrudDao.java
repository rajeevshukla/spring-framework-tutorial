package com.globallogic.crud.dao;

import org.springframework.data.repository.CrudRepository;

import com.globallogic.crud.model.Employee;

public interface EmployeeCrudDao extends CrudRepository<Employee, Integer> {

	
}
