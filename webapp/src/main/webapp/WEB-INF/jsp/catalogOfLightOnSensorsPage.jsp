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
      </tr>
  </thead>
  <tbody>
   <c:forEach var="lightOnSensor" items="${lightOnSensors}">
    <tr>
      <th scope="row">${lightOnSensor.id}</th>
      <td><a href="#">${lightOnSensor.name}</a></td>

    </tr>
   </c:forEach>
 </tbody>
</table>

<jsp:include page="footer.jsp"/>