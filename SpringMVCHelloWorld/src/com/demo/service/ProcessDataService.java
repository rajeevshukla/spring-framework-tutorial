package com.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.DatabaseAccessManagerDAO;

@Service //registering ths class bean into container as a service bean 
         // service bean have a capability of handling transaction related  rollback related, functions

public class ProcessDataService {
	@Autowired
	DatabaseAccessManagerDAO accessManagerDAO;
	
	public void processData(){

		System.out.println("processing data for business logic");
		
		
		
	}
	
}
