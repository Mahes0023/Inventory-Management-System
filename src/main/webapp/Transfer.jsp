<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>
<% 
HttpSession ses = request.getSession(false); // Get session without creating a new one
if (ses == null || ses.getAttribute("email") == null) 
{
	request.getRequestDispatcher("Login.html").forward(request, response); // Redirect to login if not logged in
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
        body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f4;
    margin: 0;
    padding: 20px;
    text-align: center;
}

h2 {
    color: #333;
    text-transform: uppercase;
}

table {
    width: 80%;
    margin: 20px auto;
    border-collapse: collapse;
    background-color: white;
    box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
    border-radius: 8px;
    overflow: hidden;
}

th, td {
    padding: 12px;
    text-align: left;
}

th {
    background-color: #007bff;
    color: white;
}

td {
    border-bottom: 1px solid #ddd;
}

tr:hover {
    background-color: #f1f1f1;
}

button {
    font-size: 16px;
    padding: 10px 20px;
    border: none;
    cursor: pointer;
    border-radius: 5px;
    margin: 10px;
    transition: all 0.3s ease-in-out;
}

.function-btn {
    background-color: #28a745;
    color: white;
}

.function-btn:hover {
    background-color: #218838;
}

.logout-btn {
    background-color: #dc3545;
    color: white;
}

.logout-btn:hover {
    background-color: #c82333;
}

form {
    display: inline-block;
}

        
    </style>
</head>
<body>
<h2>Product Details</h2>
<table>
<tr>
<th> Name</th>
<th> Price</th>
<th> Category</th>
<th> Description</th>
</tr>
<c:forEach items="${ mahesh }" var="pd">
<tr>
<td>${ pd.product_name }</td>
<td>${ pd.product_price }</td>
<td>${ pd.category }</td>
<td>${ pd.description }</td>
</tr>
</c:forEach>
</table>
<br>
<br>
<form action="Product.html" method="post">
    <button type="submit" class="function-btn">Add Product</button>
</form>
<br>
<form action="delete.html" method="post">
    <button type="submit" class="function-btn">Delete Product</button>
</form>
<br>
<br>
<form action="Home.html" method="post">
    <button type="submit" class="logout-btn">Log Out</button>
</form>

</body>
</html>