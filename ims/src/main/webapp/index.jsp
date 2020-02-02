<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>
Inventory Management
</title>
<%-- <spring:url value="./resources/css/style.css" var="exCSS" /> --%>
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/style.css"/>" />
</head>
<body>
<div class="login-box">
  <h1>Login</h1>
  <div class="textbox">
    <i class="fas fa-user"></i>
    <input type="text" placeholder="Username">
  </div>

  <div class="textbox">
    <i class="fas fa-lock"></i>
    <input type="password" placeholder="Password">
  </div>

  <input type="button" class="btn" value="Sign in">
</div>
</body>
</html>
