<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="com.example.DAO.railwayCrossingDataDAO"%>
<%@page import="com.example.model.railwayCrossingData"%>
<%@page import="java.util.*"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>search user home page</title>
</head>
<body>
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



		<br><h1><b> User Home Page </b></h1> 
		
		<h3><b> Railway Crossings </b></h3>		
		</div>
		
		<div style ="margin: 20px; padding: 10px">
		<form>
		<button type= "submit" formaction="UserHome.jsp"><b> All </b></button>
		<button type= "submit" formaction="addfavoriteCrossing.jsp"><b> Favorite Crossing</b></button>
		<button type= "submit" formaction="searchUserHomePage.jsp"><b> Search Railway Crossing</b></button>
		<button type= "submit" formaction="Logout.jsp"><b>Logout</b></button>
		</form>
		</div>	
				
				 </form>
   	 <br>
   	 <form action="searchUserRailwayResult.jsp" >
   			Search Railway Crossing<br>
   	    	<input type="text" name="search"
   	    	style=" width: 200px; margin-top: 20px"><br>
   	    	<br><input type="submit" value="Search">
   	 
   	 </form>
   	 </div>    
   	 
   	 <div style="width=100%">  
				
		<table  cellpadding="5" style="width:100%; ">		
		<tr class = "border-bottom">
		
			<th style="width: 5%">Sr. No</th>
			<th style="width: 15%">Name</th>
			<th style="width: 20%">Address</th>
			<th style="width: 20%">Landmark</th>
			<th style="width: 10%">Train Schedule</th>
			<th style="width: 10%">Person In-charge</th>
			<th style="width: 5%">Status</th>
			
			<th colspan="2" style="width: 12%">Add To Favorite </th>
			
		</tr>
		
		
			<%
			railwayCrossingDataDAO dao = new railwayCrossingDataDAO();
			List<railwayCrossingData> crossingsList = dao.displayRailwayCrossingData();
			
			for(railwayCrossingData data : crossingsList){
			%>
			<tr class = "border-bottom">
			
			<td><%= data.getCrossingId()%></td>
			<td><%= data.getCrossingName() %></td>
			<td><%= data.getAddress() %></td>
			<td><%= data.getLandmark() %></td>
			<td><%= data.getTrainSchedule() %></td>
			<td><%= data.getPersonInCharge() %></td>
			<td><%= data.getStatusCrossing() %></td>
			
			<td>
			<a href ="addfavoriteCrossing?id="<%=data.getCrossingId()%>">Add To Favorite </a></td>
			
			</tr>
			
			<%} %>
			
			
		</table>
		
		</div>
		




</body>
</html>
