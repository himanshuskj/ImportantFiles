<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="sform"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home Page</title>
</head>
<body>
<h1>Hello and Welcome to Employee Management App!!</h1>
<h2> Please Login first!!</h2>
<p>${message}</p>
<sform:form method="POST" modelAttribute="loginObj" action="login">
<table border= '1px'>
<tr>
<td><sform:label path="employeeId">Username</sform:label></td>
<td><sform:input path="employeeId"/></td>
</tr>

<tr>
<td>Enter Password</td>
<td><sform:password path="password"></sform:password></td>
</tr>


<tr>
<td>
<input type="submit" value="Login"/>
</td>
<td>
<input type="reset" value="Cancel"/>
</td>
</tr>
</table>
</sform:form>

<a href="employee">Register Employee</a>
</body>
</html>