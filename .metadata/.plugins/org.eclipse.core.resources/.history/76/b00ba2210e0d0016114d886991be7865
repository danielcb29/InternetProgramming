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

  
  
        
  <form method="post" action="?">
  <input type="hidden" name="id" value="${order.id }">
   
  
   <div>
     <label for="name">Customer name:</label> 
      <input class="personaldata" type="text" name="name" id="name" placeholder="John Snow" 
      value=<c:choose><c:when test="${not empty order.name}">"${order.name}"</c:when>
    	<c:otherwise>
    	"${user.name}"
    	</c:otherwise>
		</c:choose> 
		required <c:if test="${user.role != 'Administrador'}">readonly</c:if>/>
    </div>
    
     <div>
     <label for="email">Customer email:</label> 
      <input class="personaldata" type="text" name="email" id="email" placeholder="jsnow@starks.com" 
      value=<c:choose><c:when test="${not empty order.email}">"${order.email}"</c:when>
    	<c:otherwise>
    	"${user.email}"
    	</c:otherwise>
		</c:choose> 
		required <c:if test="${user.role != 'Administrador'}">readonly</c:if>/>
    </div>
    
       
     
   
    
        
     <div>
      <label for="tel">Telephone:</label> 
      <input class="personaldata" class="personaldata" type="tel" name="tel" id="tel" placeholder="+34 927 257 000" value="${order.tel}" required/>
    </div>   
    
   
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
       
    
    <fieldset id="type">
      <legend> Pizza Type </legend>
      <p>
        <input id="margherita" type="radio" name="type" value="margherita" required <c:if test="${order.type == 'margherita'}">checked</c:if> /> 
        <label for="margherita">Margherita (Tomato sauce, mozzarella and basil) </label> 
      </p>
      <p>
        <input id="marinara" type="radio" name="type" value="marinara" required <c:if test="${order.type == 'marinara'}">checked</c:if> /> 
        <label for="marinara">Marinara (Tomato, garlic, oregano and basil) </label> 
      </p>
      <p>
        <input id="rustica" type="radio" name="type" value="rustica" required <c:if test="${order.type == 'rustica'}">checked</c:if> /> 
        <label for="rustica">Rustica (Marguerita with goat cheese and speck) </label> 
      </p>
      
    </fieldset>

  <p>
      <label for="time">Preferred delivery time: </label>
       	<select id="time" name="delivery" required>
       	<option value="">Please select</option>
  		<option value="14:00" <c:if test="${order.delivery == '14:00'}">selected</c:if>>14:00</option>
  		<option value="14:30" <c:if test="${order.delivery == '14:30'}">selected</c:if>>14:30</option>
  		<option value="15:00" <c:if test="${order.delivery == '15:00'}">selected</c:if>>15:00</option>
  		<option value="15:30" <c:if test="${order.delivery == '15:30'}">selected</c:if>>15:30</option>
  		<option value="21:00" <c:if test="${order.delivery == '21:00'}">selected</c:if>>21:00</option>
  		<option value="21:30" <c:if test="${order.delivery == '21:30'}">selected</c:if>>21:30</option>
  		<option value="22:00" <c:if test="${order.delivery == '22:00'}">selected</c:if>>22:00</option>
  		<option value="22:30" <c:if test="${order.delivery == '22:30'}">selected</c:if>>22:30</option>
  		</select>
       
    </p>
  
  
    
    <p>
      <label for="comments">Delivery instructions:</label>
      <textarea id="comments" name="comments" maxlength="1000">${order.comments}</textarea>
    </p>
    
    
    
    
      <input id="button" type="submit" value="Submit order"/>
      </form>
</body>
</html>

