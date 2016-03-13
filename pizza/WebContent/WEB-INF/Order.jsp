<%@ page language="java" contentType="text/html; charset=UTF-8"     pageEncoding="UTF-8"%>
<!DOCTYPE html >

<html>
<head>
<meta charset="utf-8">
  <link rel="stylesheet" href="css/stylesheet.css" />
  <title>The Game of Pizzas - Orders</title>

</head>
<body>
  <h1 id="maintitle">Pizza Order</h1>
  <h2>${messages.error}</h2>


  <form method="post" action="OrderServlet">
    <div>
  
      <label for="name">Customer name:</label> 
      <input class="personaldata" type="text" name="name" id="name" placeholder="John Snow" required/>
    </div>
    <div>
      <label for="tel">Telephone:</label> 
      <input class="personaldata" class="personaldata" type="tel" name="tel" id="tel" placeholder="+34 927 257 000" required/>
    </div>
    <div>
      <label for="email">E-mail address:</label>
      <input class="personaldata" type="email" name="email" id="email" placeholder="jsnow@starks.com" required>  
    </div>
    <fieldset id="size">
      <legend> Pizza Size </legend>
      <p>        
        <input id="smallsize" type="radio" name="size" value="small" required/>
        <label for="smallsize"> Small </label>
      </p>
      <p>        
        <input id="mediumsize" type="radio" name="size" required value="medium" required/>
        <label for="mediumsize">Medium </label>
      </p>
      <p>        
        <input id="largesize" type="radio" name="size" required value="large" required/> 
        <label for="largesize">Large </label>
      </p>
      <p>        
        <input id="extralargesize" type="radio" name="size" required value="extralarge" required/> 
        <label for="extralargesize"> Extra Large </label>
      </p>
    </fieldset>
    <fieldset id="toppings">
      <legend> Pizza Toppings </legend>
      <p>
        <input id="bacon" type="checkbox" name="topping" value="bacon"/> 
        <label for="bacon">Bacon </label> 
      </p>
      <p>
        <input id="cheese" type="checkbox" name="topping" value="cheese"/> 
        <label for="cheese">Extra Cheese </label> 
      </p>
      <p>
        <input id="onion" type="checkbox" name="topping" value="onion"/>
        <label for="onion">Onion </label> 
      </p>
      <p>         
        <input id="mushroom" type="checkbox" name="topping" value="mushroom"/> 
        <label for="mushroom">Mushroom </label>
      </p>
    </fieldset>

  
    <p>
      <label for="time">Preferred delivery time: </label>
      <input id="time" type="time" min="11:00" max="21:00" step="900" name="delivery" required/>
    </p>
    <p>
      <label for="comments">Delivery instructions:</label>
      <textarea id="comments" name="comments" maxlength="1000"></textarea>
    </p>
    
    
      <input id="button" type="submit" value="Submit order"/>
      </form>
</body>
</html>