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
   <c:forEach var="sortedByValueTemperatureSensor" items="${sortedByValueTemperatureSensors}">
    <tr>
      <th scope="row">${sortedByValueTemperatureSensor.id}</th>
      <td><a href="#">${sortedByValueTemperatureSensor.name}</a></td>
      <td><a href="#">${sortedByValueTemperatureSensor.value}</a></td>
       </tr>
   </c:forEach>
 </tbody>
</table>

<jsp:include page="footer.jsp"/>