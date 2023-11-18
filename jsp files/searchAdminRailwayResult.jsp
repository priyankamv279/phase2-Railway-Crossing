<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="com.example.model.railwayCrossingData" %>
<%@ page import="com.example.DAO.railwayCrossingDataDAO" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Search admin railway result</title>
    <style>
        /* Style for the list items to display horizontally */
        ul {
            list-style-type: none;
            padding: 0;
        }

        li {
            display: inline;
            margin-right: 10px; /* Add some spacing between links */
        }
         table {
            border-collapse: collapse;
            width: 80%;
            margin-top: 20px;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }

        
    </style>
</head>
<body>
    <h1><i>Admin Home Page</i></h1>
<h3>Railway Crossings</h3>
<div>
        <form action="AdminHome.jsp" method="post">
            <input type="submit" name="home" value="Home">
            
            <input type="submit" name="addCrossing" value="Add Railway Crossing">
            <input type="submit" name="searchCrossing" value="Search Crossing">
            <input type="submit" name="logout" value="Logout">
        </form>
    </div>
    
      <%-- Perform actions based on button clicks --%>
    <% if (request.getParameter("addCrossing") != null) { %>
        <%-- Redirect to AddRailwayCrossing servlet --%>
        <% response.sendRedirect("AddRailwayCrossing.jsp"); %>
        
    <% } else if (request.getParameter("searchCrossing") != null) { %>
        <%-- Redirect to SearchCrossing servlet --%>
        <% response.sendRedirect("SearchCrossing.jsp"); %>
        
    <% } else if (request.getParameter("logout") != null) { %>
        <%-- Redirect or forward to logout handling logic --%>
       <%  response.sendRedirect("Logout.jsp"); %>
    <% } %>
    
    <br><br>
   <form action="searchAdminRailwayResult.jsp" >
			   Search Railway Crossing<br>
		       <input type="text" name="search"><br>
		       <br><input type="submit" value="Search">
		
		</form>
		
		</div>	
		
		<div style="width=100%">		
		
		<table cellpadding="5" style="width:100%; ">		
		<tr class = "border-bottom">
		
			<th style="width: 5%">Sr. No</th>
			<th style="width: 15%">Name</th>
			<th style="width: 20%">Address</th>
			<th style="width: 20%">Landmark</th>
			<th style="width: 10%">Train Schedule</th>
			<th style="width: 10%">Person In-charge</th>
			<th style="width: 5%">Status</th>
			
			<th colspan="2" style="width: 12%">Action </th>
			
		</tr>
		
		<%
			String search = request.getParameter("search");
			railwayCrossingDataDAO dao = new railwayCrossingDataDAO();
			List<railwayCrossingData> listCrossings = dao.searchRailwayCrossingData(search);
			for(railwayCrossingData data : listCrossings){
			%>
			<tr class = "border-bottom">
			
			<td><%= data.getCrossingId()%></td>
			<td><%= data.getCrossingName() %></td>
			<td><%= data.getAddress() %></td>
			<td><%= data.getLandmark() %></td>
			<td><%= data.getTrainSchedule() %></td>
			<td><%= data.getPersonInCharge() %></td>
			<td><%= data.getStatusCrossing() %></td>
			
			
		  <td><a href="updaterailwayCrossingData.jsp?id=<%= data.getCrossingId() %>">Update</a>
            <a href="deleterailwayCrossingData?id=<%= data.getCrossingId() %>">Delete</a></td>
      
			
			</tr>
			
			<%} %>
			
			
		</table>
		
		</div>
</body>
</html>

</body>
</html>
