<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<meta charset="UTF-8">
<title>Welcome Page</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">IMS</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item">
        <a class="nav-link" href="#">Home </a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="#">Add Items<span class="sr-only">(current)</span></a>
      </li>
      
<!--       <li class="nav-item">
        <a class="nav-link disabled" href="#">Disabled</a>
      </li> -->
    </ul>
    <form class="form-inline my-2 my-lg-0">
    <label>${message}</label>
    <a href="#" class="badge badge-dark">Logout</a>
    </form>
  </div>
</nav>
<div class="container">
<!-- ------------ body --------------- -->

<br/>
<c:url var="addItems" value="addItems" ></c:url>
<div class="col-sm-6">
<div class="alert alert-primary" role="alert">
  Add Item Details
</div>
<form method = "POST" action="${addItems}">
<div class="form-group" >
    <label for="itemId">Item Id</label>
    <input type="text" class="form-control" id="itemId" aria-describedby="itmIdHelp" placeholder="Item id">
    <!-- <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small> -->
  </div>
  <div class="form-group">
    <label for="itemName">Item Name</label>
    <input type="text" class="form-control" id="itemName" aria-describedby="itemNameHelp" placeholder="Item Description">
    <!-- <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone else.</small> -->
  </div> 
  <div class="form-group">
    <label for="itemCategory">Item Category</label>
    <select class="form-control" id="itemCategory">
      <option>--select--</option>
      <option>asdf</option>
      <option>aswer</option>
      <option>asaf</option>
      <option>4</option>
      <option>5</option>
    </select>
  </div>
  <div class="form-check">
    <input type="checkbox" class="form-check-input" id="activeCheck">
    <label class="form-check-label" for="activeCheck">Active</label>
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
</div>
<br/>
<div class="alert alert-primary" role="alert">
  Here are the Item details...
</div>
<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">#</th>
      <th scope="col">Item Id</th>
      <th scope="col">Item Name</th>
      <th scope="col">Category</th>
      <th scope="col">Active</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <th scope="row">1</th>
      <td>Mark</td>
      <td>Otto</td>
      <td>@mdo</td>
      <td>Y</td>
    </tr>
    <tr>
      <th scope="row">2</th>
      <td>Jacob</td>
      <td>Thornton</td>
      <td>@fat</td>
      <td>Y</td>
    </tr>
    <tr>
      <th scope="row">3</th>
      <td>Larry</td>
      <td>the Bird</td>
      <td>@twitter</td>
      <td>Y</td>
    </tr>
  </tbody>
</table>
</div>
</body>
</html>