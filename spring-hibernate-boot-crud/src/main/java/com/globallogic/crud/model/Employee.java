package com.globallogic.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEE_MASTER")
public class Employee {

	private int employeeId;
	private String employeeName;
	private String designation;
	private float salary;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getEmployeeId() {
		return employeeId;
	}


    @Column(name="emp_name")
	public String getEmployeeName() {
		return employeeName;
	}


    @Column(name="")
	public String getDesignation() {
		return designation;
	}


    @Column(name="")
	public float getSalary() {
		return salary;
	}



	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}



	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}



	public void setDesignation(String designation) {
		this.designation = designation;
	}



	public void setSalary(float salary) {
		this.salary = salary;
	}



	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName=" + employeeName + ", designation=" + designation
				+ ", salary=" + salary + "]";
	}

}
