package com.controller;

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
public class EmployeeControl {
	@Autowired
	EmployeeDAO edao;

	@RequestMapping(value = "updateEmployee", method = RequestMethod.GET)
	public String updateEmployeeInit(ModelMap map, HttpServletRequest request) {
		HttpSession session = request.getSession();
		Employee e = (Employee) session.getAttribute("emp");
		map.addAttribute("empObj", e);
		return "UpdateEmployee";
	}

	@RequestMapping(value = "updateEmployee", method = RequestMethod.POST)
	public String updateEmployee(@ModelAttribute("empObj") Employee emp,
			ModelMap map, HttpServletRequest request) {
		System.out.println("Hiii " + emp);
		int c = edao.updateEmployee(emp);
		if (c == 0) {
			map.addAttribute("message", "Updation Failed... Retry!!");
			return "UpdateEmployee";
		} else {

			String headers[] = { "employeeId", "employeeName",
					"employeeDepartment", "employeeSalary", "employeeContact",
					"employeeDOB", "employeeCity" };

			map.addAttribute("message",
					"Your details has been successfully updated!!");
			HttpSession session = request.getSession();
			session.setAttribute("emp", emp);
			session.setAttribute("headers", headers);
			if (emp.getEmployeeDepartment().equalsIgnoreCase("Admin")) {
				return "CreditHomeAdmin";
			}

			else if (emp.getEmployeeDepartment().equalsIgnoreCase("Manager")) {
				return "CreditHomeManager";
			}
		}

		return "UpdateEmployee";
	}

	@RequestMapping(value = "updateDeveloper", method = RequestMethod.GET)
	public String updateDeveloperInit(ModelMap map, HttpServletRequest request) {

		return "GetDeveloperId";
	}

	@RequestMapping(value = "editDeveloper", method = RequestMethod.GET)
	public String editDeveloper(ModelMap map, HttpServletRequest request) {
		String empid = request.getParameter("empid");
		System.out.println(empid);
		Employee e = edao.getEmployeeDetailsById(empid);
		map.addAttribute("devObj", e);
		return "UpdateDeveloper";

	}

	@RequestMapping(value = "editDeveloper", method = RequestMethod.POST)
	public String updateDeveloper(@ModelAttribute("devObj") Employee dev,
			ModelMap map, HttpServletRequest request) {

		int c = edao.updateDeveloper(dev);
		if (c == 0) {
			map.addAttribute("message", "Updation Failed... Retry!!");
			return "UpdateDeveloper";
		} else {

			String message = dev.getEmployeeName()
					+ "'s details has been successfully updated!!";
			map.addAttribute("message", message);

			return "CreditHomeManager";

		}

	}

	@RequestMapping(value = "deleteDeveloper", method = RequestMethod.GET)
	public String deleteDeveloperInit(ModelMap map, HttpServletRequest request) {

		return "GetDeveloperIdToDelete";
	}
	
	
	
	@RequestMapping(value = "deleteDeveloper", method = RequestMethod.POST)
	public String deleteDeveloper(ModelMap map, HttpServletRequest request) {
		String empid = request.getParameter("empid");
		System.out.println(empid);
		Employee dev = edao.getEmployeeDetailsById(empid);
		String name = dev.getEmployeeName();
		int c = edao.deleteDeveloperById(empid);
		if (c == 0) {
			map.addAttribute("message", "Deletion Failed... Retry!!");
			return "GetDeveloperId";
		}

		else {

			String message = name
					+ "'s details has been successfully deleted!!";
			map.addAttribute("message", message);
			return "CreditHomeManager";

		}
	}

}
