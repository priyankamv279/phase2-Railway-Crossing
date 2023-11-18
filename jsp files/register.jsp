<%@ page import="org.hibernate.Session, org.hibernate.Transaction, com.example.model.User, com.example.util.HibernateUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
</head>
<body>
    <h1>User Registration</h1>
    <form action="registerController" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required><br><br>

        <input type="submit" value="Register">
        <br><br>
        <a href="login.jsp">if already registered? click here to login.</a>
        
    </form>
</body>
</html>
