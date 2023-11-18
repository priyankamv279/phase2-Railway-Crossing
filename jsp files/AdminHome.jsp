<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page errorPage="error.jsp" %>   
<%@page import="java.util.*"%>
<%@page import="com.example.model.railwayCrossingData" %>
<%@page import="com.example.DAO.railwayCrossingDataDAO" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>AdminHome</title>
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
    
<table  cellpadding="5" style="width:100%; ">		
		<tr class = "border-bottom">        <tr>
            <th style="width: 5%">Sr. No</th>
			<th style="width: 15%">Name</th>
			<th style="width: 20%">Address</th>
			<th style="width: 20%">Landmark</th>
			<th style="width: 10%">Train Schedule</th>
			<th style="width: 10%">Person In-charge</th>
			<th style="width: 5%">Status</th>
            <th>Action</th>
        </tr>

        <%
        railwayCrossingDataDAO dao = new railwayCrossingDataDAO();
            List<railwayCrossingData> railwaycrossingList = dao.displayRailwayCrossingData();

            for(railwayCrossingData RC : railwaycrossingList) {
        %>
        <tr>
            <td><%= RC.getCrossingId() %></td>
            <td><%= RC.getCrossingName() %></td>
            <td><%= RC.getAddress() %></td>
            <td><%= RC.getLandmark() %></td>
            <td><%= RC.getTrainSchedule() %></td>
            <td><%=RC.getPersonInCharge() %></td>            
            <td><%=RC.getStatusCrossing() %></td>
                        
            <td><a href="updaterailwayCrossingData.jsp?id=<%= RC.getCrossingId() %>">Update</a>
            <a href="deleterailwayCrossingData?id=<%= RC.getCrossingId() %>">Delete</a></td>
      
        </tr>
        <% } %>
    </table>
    
</body>
</html>