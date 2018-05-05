package com.demo;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/*@Component //spring bean
@Service  // spring bean
@Repository //  spring bean
@Controller // spring bean
*/
public class Employee implements ApplicationContextAware,InitializingBean,DisposableBean {

	private String employeeId;
	private String employeeName;
	private List<String> mobileNumber; //we cannot autowire string,  & primitives,list
	

	private ApplicationContext applicationContext;
	

	private Address address;

	

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
		/*applicationContext.getBean(Address.class);
		 applicationContext.getBean("address");*/
		
		return null;
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
		
		System.out.println("Init method of employee is called");
	}

	public void destroyMethod(){
		
		System.out.println("Destroy method is called.");
	}

	public void init(){
		
		System.out.println("this default init method");
		
	}
	
	@Override
	public void destroy(){
		
		System.out.println("this is  destroy method called. of disposable.");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("after property set method is called of employee.");
		
	}
	@PostConstruct
	public void initAnnotatedMethod(){
		System.out.println("Employe init annotated method ");
	}
	
	@PreDestroy
	public void destroyAnnotatedMethod(){
		System.out.println("Destroy  employee annotated method");
	}
	
}
