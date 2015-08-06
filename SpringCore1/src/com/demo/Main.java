package com.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"spring.xml");
	
		context.registerShutdownHook();
		
		Employee employee = (Employee) context.getBean("employeeId");
		System.out.println(employee); //by default spring beans are singleton. 

		System.out.println("Employee Id:"+employee.getEmployeeId());

		System.out.println("=========");
		
		Employee employee2 = (Employee) context.getBean("employeeId");
		//will return same adress as above 
		//because spring provides singleton bean  means it reads xml on startup create an object 
		//and return it to everyone whoever ask to get the bean. 
	
		System.out.println(" Checking employee object reference :: "+ (employee==employee2));
		
		System.out.println("Checking address object in employee objects : "+(employee.getAddress()==employee2.getAddress()));
				
		//bean scope  
		
		//1:- singleton bean scope  (it means every time spring container will return same object)
		//2:- prototype    (every time spring container will return a new object)
		//3:- request  (used in http request context means spring contrainer will create object on every request. 
		//4:- session  (httpSession , this means bean object will be created per session)
		//5:- global-session (portlet context) we are not going to cover this. 
		
		//spriing mvc ,porlet mvc, & spring web flow. 
	
	
	}
}
