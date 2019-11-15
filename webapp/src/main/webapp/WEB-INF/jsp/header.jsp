<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"></link>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <title>IoT Catalog</title>
  </head>
<body>
<nav class="navbar navbar-expand-lg navbar navbar-dark bg-dark">
  <a class="navbar-brand" href="#">Menu</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="${pageContext.request.contextPath}/home">Home <span class="sr-only">(current)</span></a>
      </li>



    <div class="dropdown">
      <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
       Catalog
      </button>
      <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
        <a class="dropdown-item" href="${pageContext.request.contextPath}/catalogPage">Device catalog</a>
        <a class="dropdown-item" href="${pageContext.request.contextPath}/catalogOfLightOnSensorsPage">Light-On sensors catalog</a>
                <a class="dropdown-item" href="${pageContext.request.contextPath}/catalogOfTemperatureSensorsPage">Temperature sensors catalog</a>
      </div>
    </div>

   <sec:authorize access="!isAuthenticated()">

           <li class="nav-item">
               <a class="nav-link" href="${pageContext.request.contextPath}/login">Login</a>
           </li>
   </sec:authorize>
   <sec:authorize access="isAuthenticated()">
           <li class="nav-item">
               <a class="nav-link" href="${pageContext.request.contextPath}/logout">Logout</a>
           </li>
   </sec:authorize>
<div class="dropdown">
                  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                 Add product
                  </button>
                  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/addDevice">Add device</a>
                    <a class="dropdown-item" href="${pageContext.request.contextPath}/addLightOnSensor"> Add light-On sensor</a>
                            <a class="dropdown-item" href="${pageContext.request.contextPath}/addTemperatureSensor"> add temperature sensor</a>
                  </div>
    </ul>

     <form action="${pageContext.request.contextPath}/search" class="form-inline my-2 my-lg-0">
     <input name ="str" class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</nav>

