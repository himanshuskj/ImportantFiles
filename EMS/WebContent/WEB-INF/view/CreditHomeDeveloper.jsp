<%@page import="com.to.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="pe" uri="/WEB-INF/tags.tld" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Development Home page</title>
</head>
<body>
${message}<h2><a style="float:right" href="Signout">Signout</a></h2></br>
Welcome <%= session.getAttribute("employeeName") %>!!!</br>

<%
String headers[]=(String[])session.getAttribute("headers");
Employee emp=(Employee)session.getAttribute("emp");
%>

<pe:developer employee="<%=emp %>" headers="<%=headers %>"/>







</body>
</html>