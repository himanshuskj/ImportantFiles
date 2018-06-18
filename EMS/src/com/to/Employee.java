package com.to;


public class Employee {
	
	String employeeId;
	String employeeName;
	String employeeDepartment;
	double employeeSalary;
	long employeeContact;
	String employeeDOB;
	String employeeCity;
	String password;
	
	
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeDepartment() {
		return employeeDepartment;
	}
	public void setEmployeeDepartment(String employeeDepartment) {
		this.employeeDepartment = employeeDepartment;
	}
	public double getEmployeeSalary() {
		return employeeSalary;
	}
	public void setEmployeeSalary(double employeeSalary) {
		this.employeeSalary = employeeSalary;
	}
	public long getEmployeeContact() {
		return employeeContact;
	}
	public void setEmployeeContact(long employeeContact) {
		this.employeeContact = employeeContact;
	}
	public String getEmployeeDOB() {
		return employeeDOB;
	}
	public void setEmployeeDOB(String employeeDOB) {
		this.employeeDOB = employeeDOB;
	}
	public String getEmployeeCity() {
		return employeeCity;
	}
	public void setEmployeeCity(String employeeCity) {
		this.employeeCity = employeeCity;
	}
	


	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", employeeName="
				+ employeeName + ", employeeDepartment=" + employeeDepartment
				+ ", employeeSalary=" + employeeSalary + ", employeeContact="
				+ employeeContact + ", employeeDOB=" + employeeDOB
				+ ", employeeCity=" + employeeCity + "]";
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Employee(String employeeId, String employeeName,
			String employeeDepartment, double employeeSalary,
			long employeeContact, String employeeDOB, String employeeCity) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.employeeDepartment = employeeDepartment;
		this.employeeSalary = employeeSalary;
		this.employeeContact = employeeContact;
		this.employeeDOB = employeeDOB;
		this.employeeCity = employeeCity;
	}
	
	
	
	
	
}
