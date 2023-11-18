<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>updaterailwayCrossingData</title>
</head>
<body>
<h2>Update Railway Crossing</h2>
    <form action="UpdateRailwayCrossingController" method="post">
    <input type="hidden" name="id" value="<%= request.getParameter("id") %>">
    
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
        
        <input type="submit" value="Update">
    </form>

</body>
</html>