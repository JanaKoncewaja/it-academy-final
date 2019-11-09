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
      <td><a href="${pageContext.request.contextPath}/devicePage">${device.name}</a></td>
    </tr>
      </c:forEach>
  </tbody>
</table>
<jsp:include page="footer.jsp"/>