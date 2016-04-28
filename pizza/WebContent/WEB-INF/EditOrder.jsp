<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
  <link rel="stylesheet"  href="${pageContext.request.contextPath}/css/stylesheet.css"   />
  <title>The Game of Pizzas - Orders</title>

</head>
<body>
  <h1 id="maintitle">Pizza Order</h1>
  <h2>${messages.error}</h2>

  <c:if test="${user.role != 'Administrador'}">
  <h3>Customer name: ${user.name}</h3> 
  <h3>E-mail:${user.email}</h3>
  </c:if>
  
        
  <form method="post" action="EditOrderServlet">
  <input type="hidden" name="id" value="${order.id }">
   
   <c:if test="${user.role == 'Administrador'}">
   <div>
     <label for="name">Customer name:</label> 
      <input class="personaldata" type="text" name="name" id="name" placeholder="John Snow" value="${order.name}" required/>
    </div>
    </c:if>
       
    <div>
      <label for="tel">Telephone:</label> 
      <input class="personaldata" class="personaldata" type="tel" name="tel" id="tel" placeholder="+34 927 257 000" value="${order.tel}" required/>
    </div>
   
    <c:if test="${user.role == 'Administrador'}">
    <div>
      <label for="email">E-mail address:</label>
      <input class="personaldata" type="email" name="email" id="email" placeholder="jsnow@starks.com" required value="${order.email}">  
    </div>
     </c:if>
   
    
   
    <fieldset id="size">
      <legend> Pizza Size </legend>
      <p>        
        <input id="smallsize" type="radio" name="size" value="small" required <c:if test="${order.size == 'small'}">checked</c:if> />
        <label for="smallsize"> Small </label>
      </p>
      <p>        
        <input id="mediumsize" type="radio" name="size" required value="medium" required <c:if test="${order.size == 'medium'}">checked</c:if>/>
        <label for="mediumsize">Medium </label>
      </p>
      <p>        
        <input id="largesize" type="radio" name="size" required value="large" required <c:if test="${order.size == 'large'}">checked</c:if>/> 
        <label for="largesize">Large </label>
      </p>
      <p>        
        <input id="extralargesize" type="radio" name="size" required value="extralarge" required <c:if test="${order.size == 'extralarge'}">checked</c:if> /> 
        <label for="extralargesize">Extra Large </label>
      </p>
    </fieldset>
    <fieldset id="toppings">
      <legend> Pizza Toppings </legend>
      <p>
        <input id="bacon" type="checkbox" name="topping" value="bacon"  <c:if test="${fn:containsIgnoreCase(order.toppings, 'bacon')}">checked</c:if> /> 
        <label for="bacon">Bacon </label> 
      </p>
      <p>
        <input id="cheese" type="checkbox" name="topping" value="cheese"  <c:if test="${fn:containsIgnoreCase(order.toppings, 'cheese')}">checked</c:if> /> 
        <label for="cheese">Extra Cheese </label> 
      </p>
      <p>
        <input id="onion" type="checkbox" name="topping" value="onion" <c:if test="${fn:containsIgnoreCase(order.toppings, 'onion')}">checked</c:if> />
        <label for="onion">Onion </label> 
      </p>
      <p>         
        <input id="mushroom" type="checkbox" name="topping" value="mushroom" <c:if test="${fn:containsIgnoreCase(order.toppings, 'mushroom')}">checked</c:if> /> 
        <label for="mushroom">Mushroom </label>
      </p>
    </fieldset>

  
    <p>
      <label for="time">Preferred delivery time: </label>
      <input id="time" type="time" min="11:00" max="21:00" step="900" name="delivery" required value="${order.delivery}"/>
    </p>
    <p>
      <label for="comments">Delivery instructions:</label>
      <textarea id="comments" name="comments" maxlength="1000">${order.comments}</textarea>
    </p>
    
    
      <input id="button" type="submit" value="Change order"/>
      </form>
</body>
</html>

