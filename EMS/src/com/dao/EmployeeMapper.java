package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.to.Employee;

public class EmployeeMapper implements  RowMapper<Employee>{

	@Override
	public Employee mapRow(ResultSet rs, int arg1) throws SQLException {
		Employee e=new Employee();
		e.setEmployeeId(rs.getString("employeeid"));
		e.setEmployeeName(rs.getString("employeename"));
		e.setEmployeeDepartment(rs.getString("employeedepartment"));
		e.setEmployeeSalary(rs.getDouble("employeesalary"));
		e.setEmployeeContact(rs.getLong("employeecontact"));
		e.setEmployeeDOB(rs.getString("employeedob"));
		e.setEmployeeCity(rs.getString("employeecity"));
		return e;
	}

}
