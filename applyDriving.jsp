<%@page import="code.microsystem.Service.UserService"%>
<%@page isELIgnored="false" %>
<%@page import="code.microsystem.Entity.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="include/userHeader.jsp">
<c:param name="title" value="Apply for Driving"></c:param>
</c:import>

<div class="container mtb">
<div class="row">
<div class="col-lg-6">


<%
int id = (Integer)session.getAttribute("id");
String email = (String)session.getAttribute("email");
User u = UserService.viewUser(email);
%>

Welcome User <%=email %>
<c:set var="u" value="<%=u %>"></c:set>
<form action="UserController?page=udriving" method="post">
<div class="form-group">
<label>Select The Service You Are Looking For</label>
<select id="test" name="test" class="form-control" value="${u.test}" readonly="readonly">
<option value="Driving Licence">Driving Licence</option>
<option value="Learner's Licence">Learner's Licence</option>
<option value="Issue of Duplicate Driving Licence ">Issue of Duplicate Driving Licence </option>
<option value="Permanent Licence">Permanent Licence</option>
<option value="Renewal Driving Licence">Renewal Driving Licence</option>
</select>
</div>
<h2>Personal Information</h2>
<div class="form-group">
<label>Your ID</label>
<input type="text" name="id" id="id" class="form-control" value="${u.id}"  readonly="readonly">
</div>
<div class="form-group">
<label>Your name</label>
<input type="text" name="name" id="name"  class="form-control" value="${u.name}"  readonly="readonly" >
</div>
<div class="form-group">
<label>Your Email</label>
<input type="email" name="email" id="email" class="form-control" value="${u.email}"  readonly="readonly">
</div>
<div class="form-group">
<label>Your City</label>
<input type="text" name="city" id="city" class="form-control" value="${u.city}"  readonly="readonly">
</div>
<div class="form-group">
<label>Your Address</label>
<input type="text" name="address" id="address"  class="form-control" value="${u.address}"  readonly="readonly">
</div>
<div class="form-group">
<label>Your Mobile Number</label>
<input type="text" name="mobile" id="mobile" class="form-control" value="${u.mobile}"  readonly="readonly">
</div>

<button type="submit" class="btn btn-success">CONTINUE</button>
</form>
</div>
</div>
</div>
<c:import url="include/footer.jsp"></c:import>


