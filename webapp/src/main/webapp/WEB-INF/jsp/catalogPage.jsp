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
      <td>${device.name}</td>
      <td>${device.ip}</td>
      <td>${device.location}</td>
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