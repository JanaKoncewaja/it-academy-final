<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>
<table class="table table-dark">
  <thead class="thead-light">
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Name</th>
      <th scope="col">Value</th>

    </tr>
  </thead>
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