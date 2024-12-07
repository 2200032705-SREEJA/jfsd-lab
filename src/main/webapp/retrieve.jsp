<%@ page language="java" contentType="text/html; charset=ISO-8859-1" 
    pageEncoding="ISO-8859-1"%> 
<!DOCTYPE html> 
<html> 
<head> 
<meta charset="ISO-8859-1"> 
<title>Select data from table</title> 
</head> 
<body> 
<h1>Retrieve data from table</h1>
<%@page import="java.util.*" %> 
<%@page import="com.model.*" %> 
<% 
@SuppressWarnings("unchecked") List<Student> list = (List<Student>) request.getAttribute("slist"); 
%> 
<table border="1"> 
<tr><th>Student Id</th><th>Student Name</th></tr> 
<% 
for(Student s:list) { 
%> 
<tr> 
<td><%=s.getSid() %></td> 
<td><%=s.getSname() %></td> 
</tr> 
<%} %> 
</table> 
</body> 
</html>
