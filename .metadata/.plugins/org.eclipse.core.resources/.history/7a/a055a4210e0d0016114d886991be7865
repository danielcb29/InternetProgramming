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
<h1> Confirmed orders:</h1> 
<div id="links">
<a class="icono" href="OrderServlet"><img src="${pageContext.request.contextPath}/img/new.png" alt="New Order"></a> 
<a class="icono" href="${pageContext.request.contextPath}/LogoutServlet"><img src="${pageContext.request.contextPath}/img/logout.png" alt="Logout"></a>
</div>
	    
		<table>
		<thead>
		<tr>
		<th>Order id</th>
		<th>Customer name</th>
		<th>Customer phone</th>
		<th>Customer email</th>
		<th>Size</th>
		<th>Type</th>
		<th>Delivery</th>
		<th>Comments</th>
		<th>EDIT</th>
		<th>DELETE</th>
		</thead>
		<tbody>
		<c:forEach var="order" items="${orderList}">
		<tr> 
		<td>${order.id}</td>
		<td>${order.name}</td>
	    <td>${order.email}</td>
	    <td>${order.tel}</td>
	    <td>${order.size}</td>
		<td>${order.type}</td>
		<td>${order.delivery}</td>
		<td>${order.comments}</td>
		<td class="icono"><a href="<c:url value='EditOrderServlet?id=${order.id }'/>" ><img src="${pageContext.request.contextPath}/img/edit.png" alt="edit ${order.id }" /></a></td>
		<td class="icono"><a href="<c:url value='DeleteOrderServlet?id=${order.id }'/>" ><img src="${pageContext.request.contextPath}/img/delete.png" alt="delete ${order.id }" /></a></td>
	    </tr>	
	    </c:forEach>
	    </tbody>	
		</table>	
		
		
</body>
</html>
