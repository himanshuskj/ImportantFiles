package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.to.Employee;


@Controller
public class HomeController {

	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public String showHello(ModelMap map){
		Employee el = new Employee();
		map.addAttribute("loginObj", el);
		return "Home";
	}
}
