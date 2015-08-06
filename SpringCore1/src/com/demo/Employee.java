package com.demo;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/*@Component //spring bean
@Service  // spring bean
@Repository //  spring bean
@Controller // spring bean
*/
public class Employee implements ApplicationContextAware {

	private String employeeId;
	private String employeeName;
	private List<String> mobileNumber; //we cannot autowire string,  & primitives,list
	
	private ApplicationContext applicationContext;
	

	private Address address;

	public Employee(String employeeId, String employeeName) {
		this.employeeId = employeeId;
		this.employeeName = employeeName;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public Address getAddress() {
		// ask this address from container.. for every get request..
		//how to access container inside a bean 
		return (Address)applicationContext.getBean("address");
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	public List<String> getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(List<String> mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName="
				+ employeeName + ", mobileNumber=" + mobileNumber
				+ ", address=" + address + "]";
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		 this.applicationContext=applicationContext;
		
	}
	
	public void initMethod(){
		
		System.out.println("Init method is called");
	}

	public void destroyMethod(){
		
		System.out.println("Destroy method is called.");
	}

	
}
