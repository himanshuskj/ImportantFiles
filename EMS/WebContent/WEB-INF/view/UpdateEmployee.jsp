<%@page import="com.to.Employee"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="sform"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Employee</title>
</head>
<body>
<h2>Welcome to Employee Update Screen</h2>
<% Employee emp=(Employee)session.getAttribute("emp");%>
<sform:form method="POST" modelAttribute="empObj" action="updateEmployee">
<table border= '1px'>
<tr>
<td><sform:label path="employeeId">Employee ID</sform:label></td>
<td><sform:input path="employeeId"/></td>
</tr>
<tr>
<td><sform:label path="employeeName">Employee Name</sform:label></td>
<td><sform:input path="employeeName"/></td>
</tr>
<tr>
<td><sform:label path="employeeDepartment">Employee Department</sform:label></td>
<td><sform:input path="employeeDepartment"/></td>
</tr>
<tr>
<td><sform:label path="employeeSalary">Employee Salary</sform:label></td>
<td><sform:input path="employeeSalary"/></td>
</tr>
<tr>
<td><sform:label path="employeeContact">Employee Contact</sform:label></td>
<td><sform:input path="employeeContact"/></td>
</tr>

<tr>
<td><sform:label path="employeeDOB">Employee DOB</sform:label></td>
<td><sform:input path="employeeDOB"/></td>
</tr>


<tr>
<td><sform:label path="employeeCity">Employee City</sform:label></td>
<td><sform:input path="employeeCity"/></td>
</tr>

<tr>
<td><sform:label path="password">Employee Password</sform:label></td>
<td><sform:input path="password"/></td>
</tr>



<tr>
<td>
<input type="submit" value="Save"/>
</td>
<td>
<input type="reset" value="Cancel"/>
</td>
</tr>
</table>
</sform:form>
${message}
</body>
</html>