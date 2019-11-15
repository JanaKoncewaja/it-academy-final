<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>
<form action="${pageContext.request.contextPath}/addLightOnSensor/LightOnSensor" method="POST">
  <div class="form-group">
    <label for="exampleInputEmail1">Sensor Name</label>
    <input type="text" name="name" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter sensor name">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1"> Sensor value</label>
    <input type="number" name="price" class="form-control" id="exampleInputPassword1" placeholder="Enter sensor value">
  </div>

 <button type="submit" class="btn btn-primary">Submit</button>
</form>

<jsp:include page="footer.jsp"/>


