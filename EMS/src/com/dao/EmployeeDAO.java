package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.dbutil.MyOracleDBConnection;
import com.to.Employee;

public class EmployeeDAO {

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(this.dataSource);
	}

	public boolean isValidLogonCredentials(Employee emp)
			throws ClassNotFoundException, SQLException {
		boolean flag = false;
		Connection connection = MyOracleDBConnection.openConnection();
		PreparedStatement preparedStatement = connection
				.prepareStatement("select username from login where username=? and password=?");
		preparedStatement.setString(1, emp.getEmployeeId());
		preparedStatement.setString(2, emp.getPassword());

		ResultSet resultSet = preparedStatement.executeQuery();

		if (resultSet.next()) {
			flag = true;

		}

		return flag;
	}

	public int addEmployee(Employee e) {
		int count = 0;
		String query = "insert into employee values(?,?,?,?,?,?,?)";
		count = jdbcTemplate.update(query, e.getEmployeeId(),
				e.getEmployeeName(), e.getEmployeeDepartment(),
				e.getEmployeeSalary(), e.getEmployeeContact(),
				e.getEmployeeDOB(), e.getEmployeeCity());
		String query2 = "insert into login values(?,?)";
		jdbcTemplate.update(query2, e.getEmployeeId(), e.getPassword());

		return count;
	}

	public List<Employee> getAllEmployees() {
		String sql = "select distinct * from employee order by age desc";
		List<Employee> listemp = jdbcTemplate.query(sql, new EmployeeMapper());
		return listemp;
	}

	public Employee getEmployeeDetails(Employee emp) {

		String sql = "select * from employee where employeeid=?";
		String employeeId = emp.getEmployeeId();
		List<Employee> emp1 = jdbcTemplate.query(sql, new EmployeeMapper(),
				employeeId);
		return emp1.get(0);
	}

	public Employee getEmployeeDetailsById(String employeeId) {
		System.out.println(employeeId);
		String sql = "select * from employee where employeeid=?";
		List<Employee> emp1 = jdbcTemplate.query(sql, new EmployeeMapper(),
				employeeId);
		return emp1.get(0);
	}

	public int updateEmployee(Employee e) {
		int count = 0;
		String query = "update employee set employeename=?, employeedepartment=?, employeesalary=?, employeecontact=?, employeedob=?, employeecity=? where employeeid=?";
		count = jdbcTemplate.update(query, e.getEmployeeName(),
				e.getEmployeeDepartment(), e.getEmployeeSalary(),
				e.getEmployeeContact(), e.getEmployeeDOB(),
				e.getEmployeeCity(), e.getEmployeeId());

		String query2 = "update login set password=? where username=?";
		jdbcTemplate.update(query2, e.getPassword(), e.getEmployeeId());

		return count;
	}

	public int updateDeveloper(Employee e) {
		int count = 0;
		String query = "update employee set employeename=?, employeedepartment=?, employeesalary=?, employeecontact=?, employeedob=?, employeecity=? where employeeid=?";
		count = jdbcTemplate.update(query, e.getEmployeeName(),
				e.getEmployeeDepartment(), e.getEmployeeSalary(),
				e.getEmployeeContact(), e.getEmployeeDOB(),
				e.getEmployeeCity(), e.getEmployeeId());

		return count;
	}

	public int deleteDeveloperById(String empid) {

		int count = 0;
		String query = "delete from employee where employeeid=?";
		count = jdbcTemplate.update(query, empid);

		String query2 = "delete from login where username=?";
		jdbcTemplate.update(query2, empid);

		return count;
	}

}
