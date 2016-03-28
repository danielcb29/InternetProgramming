<%@ page language="java" contentType="text/html; charset=UTF-8"     pageEncoding="UTF-8"%>
<!DOCTYPE html >

<html>
<head>
<meta charset="utf-8">
  <link rel="stylesheet"  href="${pageContext.request.contextPath}/css/stylesheet.css"   />
  <title>Order confirmation</title>

</head>
<body>
 <h1>Order confirmation</h1>
		<ul>
		<li>Customer name: ${order.name}</li>
		<li>Customer email: ${order.email}</li>
		<li>Customer phone: ${order.tel}</li>
		<li>Size: ${order.size}</li>
		<li>Toppings: ${order.toppings}</li>
		<li>Delivery time: ${order.delivery}</li>
		<li>Comments: ${order.comments}</li>		
		</ul>
		<form method="POST" action="CheckOrderServlet"><button>ok</button></form>
</body>
</html>

