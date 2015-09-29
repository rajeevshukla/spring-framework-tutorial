package com.demo.aspects;

public class LogginAspects {

	
	public void logBeforMethod(){
		System.out.println("This statment is being  printed before method");
	}
	
	public void logAfterMethod(){
		System.out.println("This method is going to be printed after method");
	}
	
}
