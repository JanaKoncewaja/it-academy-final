<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>
<table class="table table-hover">
  <thead>
    <tr>
       <th scope="col">Id</th>
        <th scope="col">Name</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="device" items="${devices}">
    <tr>
      <th scope="row">${device.id}</th>
      <td><a href="#">${device.name}</a></td>
      <td><a href="#">${device.ip}</a></td>
    </tr>
      </c:forEach>
  </tbody>
  <tbody>
    <c:forEach var="lightOnSensor" items="${lightOnSensors}">
      <tr>
        <th scope="row">${lightOnSensor.id}</th>
        <td><a href="#">${lightOnSensor.name}</a></td>
        <td><a href="#">${temperatureSensor.value}</a></td>
      </tr>
        </c:forEach>
    </tbody>
      <tbody>
        <c:forEach var="temperatureSensor" items="${temperatureSensors}">
          <tr>
            <th scope="row">${temperatureSensor.id}</th>
            <td><a href="#">${temperatureSensor.name}</a></td>
            <td><a href="#">${temperatureSensor.value}</a></td>
          </tr>
            </c:forEach>
        </tbody>
</table>
<jsp:include page="footer.jsp"/>