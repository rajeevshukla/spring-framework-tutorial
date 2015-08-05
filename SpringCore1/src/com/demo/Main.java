package com.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"spring.xml");
		Employee employee = (Employee) context.getBean("employeeId");
		System.out.println(employee);

		System.out.println("Employee Id:"+employee.getEmployeeId());

		System.out.println("=========");
		
		Employee employee2 = (Employee) context.getBean("employeeId");
		System.out.println(employee2);
		System.out.println("Employee Id:"+employee2.getEmployeeId());
		//will return same adress as above 
		//because spring provides singleton bean  means it reads xml on startup create an object 
		//and return it to everyone whoever ask to get the bean. 
	
		
        System.out.println("=========");
		
        Employee employee3 = (Employee) context.getBean("employeeId");
		System.out.println(employee3);
		System.out.println("Employee Id : "+employee3.getEmployeeId());
         System.out.println("Employee Address  "+employee3.getAddress());
		
		//bean scope  
		
		//1:- singleton bean scope 
	
	
	}
}
