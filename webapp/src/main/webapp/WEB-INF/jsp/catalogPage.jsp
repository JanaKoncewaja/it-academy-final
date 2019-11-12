<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>
<table class="table table-dark">
  <thead class="thead-light">
    <tr>
      <th scope="col">Id</th>
      <th scope="col">Name</th>
      <th scope="col">Ip</th>
      <th scope="col">Location</th>
    </tr>
  </thead>
  <tbody>
   <c:forEach var="device" items="${devices}">
    <tr>
      <th scope="row">${device.id}</th>
      <td><a href="#">${device.name}</a></td>
      <td><a href="#">${device.ip}</a></td>
      <td><a href="#">${device.location}</a></td>
    </tr>
   </c:forEach>
 </tbody>
</table>
<jsp:include page="footer.jsp"/>