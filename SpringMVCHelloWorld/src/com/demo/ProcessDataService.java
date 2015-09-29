package com.demo;

import org.springframework.stereotype.Service;

@Service //registering ths class bean into container as a service bean 
 // service bean have a capability of handling transaction related  rollback related, fucution
public class ProcessDataService {

	
	public void processData(){
		
		System.out.println("processing data for business logic");
		
	}
	
}
