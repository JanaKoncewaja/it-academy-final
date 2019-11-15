<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>
<div class="dropdown">
  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
   Sort
  </button>
  <body>
  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
    <a class="dropdown-item" href="${pageContext.request.contextPath}/catalogOfLightOnSensorsPage/sortedLightOnSensors"">Sort by name</a>
  </div>
</div>
<table class="table table-dark">
  <thead class="thead-light">
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Name</th>
      <th scope="col">Value</th>
      <th scope="col">Device</th>
      </tr>
  </thead>
  <tbody>
   <c:forEach var="lightOnSensor" items="${lightOnSensors}">
    <tr>
      <td scope="row">${lightOnSensor.sensor.id}</td>
      <td>${lightOnSensor.sensor.name}</td>
      <td>${lightOnSensor.sensor.value}</td>
      <td>${lightOnSensor.deviceName}</td>
    </tr>
   </c:forEach>
 </tbody>
</table>
<html>
 <style>
body {
  background-image: url('smart.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: cover;
}
</style>
<html>
<jsp:include page="footer.jsp"/>