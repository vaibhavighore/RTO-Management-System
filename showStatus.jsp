<%@page import="code.microsystem.Entity.User"%>
<%@page import="code.microsystem.Entity.Application"%>
<%@page import="code.microsystem.Service.UserService"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="include/userHeader.jsp">
<c:param name="title" value="Change Application Status"></c:param>
</c:import>

<div class="container mtb">
<div class="row">
<div class="col-lg-6">
<%
String email = (String)session.getAttribute("email");
Application a = UserService.viewApplication(email);
%>
<h2>Change Application Status</h2>
<c:set var="a" value="<%=a %>"></c:set>
<form action="AdminController?page=#" method="post">
<div class="form-group">
<label>Registration Id</label>
<input type="text" name="id" id="id" readonly="readonly" class="form-control" value="<%=a.getId()%>">
</div>

<div class="form-group">
<label>Select The Service You Are Looking For</label>
<input type="text" name="test" id="test" readonly="readonly" class="form-control"  value="<%=a.getTest()%>">
</div>

<div class="form-group">
<label>Name</label>
<input type="text" name="name" id="name" readonly="readonly" class="form-control" value="<%=a.getName()%>">
</div>

<div class="form-group">
<label>Email</label>
<input type="text" name="email" id="email" readonly="readonly" class="form-control" value="<%=a.getEmail()%>">
</div>

<div class="form-group">
<label>Status</label>
<input type="text" name="status" id="status" readonly="readonly" class="form-control" value="<%=a.getStatus()%>">
</div>

</form>
</div>
</div>
</div>

<c:import url="include/footer.jsp"></c:import>