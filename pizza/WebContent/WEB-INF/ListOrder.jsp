<%@ page language="java" contentType="text/html; charset=UTF-8"     pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html id="list">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet"  href="${pageContext.request.contextPath}/css/stylesheet.css"   />
<title>Orders confirmed!</title>
</head>
<body>
<c:if test="${user.role != 'Administrador'}">
<h1>Your confirmed orders:</h1> 
 </c:if>
 <c:if test="${user.role == 'Administrador'}">
<h1>All confirmed orders:</h1> 
 </c:if>
 <div id="links">
<a href="OrderServlet">New Order!</a> 
<a href="${pageContext.request.contextPath}/LogoutServlet">Log out</a>
</div>
	    
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
