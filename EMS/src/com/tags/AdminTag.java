package com.tags;

import java.io.IOException;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.to.Employee;

public class AdminTag extends SimpleTagSupport {

	private String headers[];

	private Employee employee;

	public void setHeaders(String headers[]) {
		this.headers = headers;
	}

	public String[] getHeaders() {
		return headers;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public void doTag() throws IOException {
		JspWriter out = getJspContext().getOut();
		out.print("<table border='1px'>");
		out.print("<tr>");
		for (String header : headers) {
			out.print("<th>" + header + "</th>");
		}
		out.print("</tr>");

		out.print("<tr>");
		out.print("<td>" + employee.getEmployeeId() + "</td>");
		out.print("<td>" + employee.getEmployeeName() + "</td>");
		out.print("<td>" + employee.getEmployeeDepartment() + "</td>");
		out.print("<td>" + employee.getEmployeeSalary() + "</td>");
		out.print("<td>" + employee.getEmployeeContact() + "</td>");
		out.print("<td>" + employee.getEmployeeDOB() + "</td>");
		out.print("<td>" + employee.getEmployeeCity() + "</td>");
		out.print("<td> <a href='updateEmployee'>Edit your details</a> </td>");
		out.print("<td> <a href='updateDeveloper'>Update any Developer's Details</a> </td>");
		out.print("<td> <a href='deleteDeveloper'>Delete any Developer's Details</a> </td>");

		out.print("</tr>");

		out.print("</table>");
	}

}
