<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>
<form action="${pageContext.request.contextPath}/addLightOnSensor" method="POST">
  <div class="form-group">
    <font color ="white"><label for="name">Sensor Name</label></font>
    <input type="text" name="name" class="form-control" id="name" aria-describedby="emailHelp" placeholder="Enter sensor name">
  </div>
  <div class="form-group">
    <font color ="white"><label for="value"> Sensor value</label></font>
    <input type="number" name="value" class="form-control" id="value" placeholder="Enter sensor value">
  </div>

 <button type="submit" class="btn btn-primary">Submit</button>
</form>
<html>
 <style>
body {
  background-image: url('imge.jpg');
  background-repeat: no-repeat;
  background-attachment: fixed;
  background-size: cover;
}
</style>
<html>
<jsp:include page="footer.jsp"/>


