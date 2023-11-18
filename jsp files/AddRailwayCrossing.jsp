<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page errorPage="error.jsp" %>   
<%@page import="java.util.*"%>
<%@page import="com.example.DAO.railwayCrossingDataDAO"%>
<%@page import="com.example.model.railwayCrossingData"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AddRailwayCrossing</title>
</head>
<body>
<h2>Add Railway Crossing</h2>
    <form action="AddRailwayCrossingController" method="post">
        Railway Crossing Name: <input type="text" name="crossingName"><br><br>
        Railway Crossing Address: <input type="text" name="crossingAddress"><br><br>
        Landmark: <input type="text" name="landmark"><br><br>
        Train Schedule: <input type="Time" name="trainSchedule" ><br><br>
        Person In-charge: <input type="text" name="personInCharge"><br><br>
               
       Status:
				<br>
	<select name="statusCrossing">
    <optgroup label="Status">
        <option value="OPEN">OPEN</option>
        <option value="CLOSED">CLOSED</option>
    </optgroup>
</select>

				
				
				<br><br>
        
        <input type="submit" value="ADD">
    </form>
</body>
</html>