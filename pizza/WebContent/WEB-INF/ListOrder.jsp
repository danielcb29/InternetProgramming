<%@ page language="java" contentType="text/html; charset=UTF-8"     pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Order confirmed!</title>
</head>
<body>
<h1>Order confirmed!</h1> 
	    <a href="OrderServlet">New Order!</a>
		<table>
		<thead>
		<tr>
		<th>Customer name</th>
		<th>Customer phone</th>
		<th>Customer email</th>
		<th>Size</th>
		<th>Toppings</th>
		<th>Delivery</th>
		<th>Comments</th>
		<th>ACTIONS</th>
		</thead>
		<tbody>
		<c:forEach var="order" items="${orderList}">
		<tr> 
		<td><a href="<c:url value='EditOrderServlet?id=${order.id }'/>" >${order.name}</a></td>
		<td>${order.tel}</td>
	    <td>${order.email}</td>
	    <td>${order.size}</td>
		<td>${order.toppings}</td>
		<td>${order.delivery}</td>
		<td>${order.comments}</td>
		<td><a href="<c:url value='DeleteOrderServlet?id=${order.id }'/>" >delete</a></td>
	    </tr>	
	    </c:forEach>
	    </tbody>	
		</table>	
</body>
</html>
