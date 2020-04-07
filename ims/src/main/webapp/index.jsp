<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page session="false"%>
<html>
<head>
<title>
Inventory Management
</title>
<%-- <spring:url value="./resources/css/style.css" var="exCSS" /> --%>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>" />
</head>
<body>

<%-- <form:form action="${loginAction}" modelAttribute="users">
	<div class="login-box">
  <h1>Login</h1>
  	<div class="textbox">
  		<i class="fas fa-user"></i>
  		<form:input path="email" cssClass="" placeholder="Username"/>
  	</div>
  	<div class="textbox">
    <i class="fas fa-lock"></i>
    <form:input path="password" placeholder="Password"/>
  </div>
   <input type="button" class="btn" value="Sign in">
  </div>
</form:form> --%>

<c:url var="loginAction" value="welcome" ></c:url>
<div class="login-box">
  <h1>Login</h1>
 
 <%--  <form:form action="${loginAction}" modelAttribute="user" method="POST">
  	<div class="textbox">
    <i class="fas fa-user"></i>
    <form:input path="email" placeholder="Email"/>
  </div>
  <div class="textbox">
    <i class="fas fa-lock"></i>
    <form:password path="password" placeholder="Password"/>
  </div>
  <form:button value="Login" ></form:button>
  </form:form> 
   --%>
  
  
  <form method="post" action="${loginAction}">
  <div class="textbox">
    <i class="fas fa-user"></i>
    <input type="text" placeholder="Username" name="email">
  </div>

  <div class="textbox">
    <i class="fas fa-lock"></i>
    <input type="password" placeholder="Password" name="password">
  </div>
<span>${message}</span>
  <input type="submit" class="btn" value="Sign in">
  </form>
  
  
</div>
</body>
</html>
