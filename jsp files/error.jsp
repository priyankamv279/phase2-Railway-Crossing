<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
   pageEncoding="ISO-8859-1"%>
<%@page isErrorPage="true" %>       
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ERROR</title>
</head>
<body>
<div style="text-align: center; margin: 30px">
		<h1><b> ERROR PAGE </b></h1>
		
		<br><br>
<%= "The exception that occurred is - " + exception %>
</div>
</body>
</html>