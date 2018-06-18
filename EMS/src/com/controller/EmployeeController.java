package com.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dao.EmployeeDAO;
import com.to.Employee;

@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeDAO edao;

	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(@ModelAttribute("loginObj") Employee empl, ModelMap map,HttpServletRequest request) {
		System.out.println(empl.getEmployeeId());
		
		boolean flag=false;
		try {
			flag=edao.isValidLogonCredentials(empl);
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		
		if(flag)
		{
			System.err.println("logged in");
			Employee employeeDetails=edao.getEmployeeDetails(empl);
			HttpSession session = request.getSession();
			session.setAttribute("employeeName", employeeDetails.getEmployeeName());
			session.setAttribute("emp", employeeDetails);
			map.addAttribute("emp",employeeDetails);
			String headers[]={"employeeId","employeeName","employeeDepartment","employeeSalary","employeeContact","employeeDOB","employeeCity"};
			session.setAttribute("headers", headers);
			map.addAttribute("message", "You have successfully logged in!!");
			if(employeeDetails.getEmployeeDepartment().equalsIgnoreCase("Developer"))
			{
			return "CreditHomeDeveloper";
			}
			
			else if(employeeDetails.getEmployeeDepartment().equalsIgnoreCase("Admin"))
			{
			return "CreditHomeAdmin";
			}
			
			else if(employeeDetails.getEmployeeDepartment().equalsIgnoreCase("Manager"))
			{
			return "CreditHomeManager";
			}
			
		}
		
		
		map.addAttribute("message", "Invalid Credentials");
		return "Home";
		
		
	}
	
	
	
	@RequestMapping(value= "employee", method = RequestMethod.GET)
	public String showEmployeeRegisteration(ModelMap map) {
		Employee e = new Employee();
		map.addAttribute("empObj", e);
		return "Register";
	}
	
	
	@RequestMapping(value = "addEmployee", method = RequestMethod.POST)
	public String registerEmployeeDetails(
			@ModelAttribute("empObj") Employee emp, ModelMap map,HttpServletRequest request) {
		System.out.println("Hiii " + emp);
		int c = edao.addEmployee(emp);
		if (c == 0) {
			map.addAttribute("message", "Insertion Failed... Retry!!");
			return "register";
		} else {
			
			map.addAttribute("emp", emp);
			HttpSession session = request.getSession();
			session.setAttribute("employeeName", emp.getEmployeeName());
			session.setAttribute("emp", emp);
			String headers[]={"employeeId","employeeName","employeeDepartment","employeeSalary","employeeContact","employeeDOB","employeeCity"};
			session.setAttribute("headers", headers);
			map.addAttribute("message", "You have successfully registered!!");
			
			if(emp.getEmployeeDepartment().equalsIgnoreCase("Developer"))
			{
				
			return "CreditHomeDeveloper";
			}
			
			else if(emp.getEmployeeDepartment().equalsIgnoreCase("Admin"))
			{
			return "CreditHomeAdmin";
			}
			
			else if(emp.getEmployeeDepartment().equalsIgnoreCase("Manager"))
			{
			return "CreditHomeManager";
			}
		}
		
		return "register";
	}
	
	@RequestMapping(value= "Signout", method = RequestMethod.GET)
	public String signoutEmployee(ModelMap map,HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.invalidate();
		Employee e = new Employee();
		map.addAttribute("loginObj", e);
		map.addAttribute("message", "You have been successfully logged out.");
		return "Home";
	}
	

}
