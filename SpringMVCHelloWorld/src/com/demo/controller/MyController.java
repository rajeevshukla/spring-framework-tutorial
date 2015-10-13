package com.demo.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.demo.service.ProcessDataService;

@Controller
public class MyController { //this bean will be registered as a handler bean.

	@Autowired
	private ProcessDataService processData;


	@RequestMapping(value="/abc.htm", method=RequestMethod.GET)
	public String abc(){
		System.out.println("we caught your request ");
		return "index"; //index is a view name
	}


	@RequestMapping("/welcome.htm")
	public ModelAndView pqr(){
		ModelAndView mav=new ModelAndView("admin/welcome");
		processData.processData();
		mav.addObject("userName", "rajeev");
		return mav;
	}

	@RequestMapping("/welcome1.htm")
	public Model pqr1(Model model){


		return model;
	}

	@RequestMapping("/welcome2.htm")
	public void pqr2(Model model,HttpSession session){


	}

}
