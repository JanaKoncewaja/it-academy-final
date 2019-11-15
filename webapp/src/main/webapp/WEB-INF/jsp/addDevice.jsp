<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="header.jsp"/>
<form action="${pageContext.request.contextPath}/addDevice" method="POST" >

  <div class="form-group">
    <label for="name">Device Name</label>
    <input type="text" name="name" class="form-control" id="name"  placeholder="Enter device name">
  </div>
 <div class="form-group">
    <label for="ip">Device ip</label>
    <input type="text" name="ip" class="form-control" id="ip"  placeholder="Enter device ip">
  </div>
   <div class="form-group">
      <label for="location">Device location</label>
      <input type="text" name="location" class="form-control" id="location"  placeholder="Enter device location">
    </div>

 <button type="submit" class="btn btn-primary">Submit</button>
</form>

<jsp:include page="footer.jsp"/>