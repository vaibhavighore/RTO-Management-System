<%@page import="code.microsystem.Entity.User"%>
<%@page import="code.microsystem.Entity.Application"%>
<%@page import="code.microsystem.Service.AdminService"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="include/adminHeader.jsp">
<c:param name="title" value="Change Application Status"></c:param>
</c:import>

<div class="container mtb">
<div class="row">
<div class="col-lg-6">
<%
int id = Integer.parseInt(request.getParameter("id"));
User a = AdminService.getStatus(id);
%>
<h2>Change Application Status</h2>
<c:set var="a" value="<%=a %>"></c:set>
<form action="AdminController?page=changeSt" method="post">
<div class="form-group">
<label>Registration Id</label>
<input type="text" name="id" id="id" readonly="readonly" class="form-control" value="<%=a.getId()%>">
</div>

<div class="form-group">
<label>Select The Service You Are Looking For</label>
<select id="test" name="test" class="form-control" value="${a.test}" readonly="readonly">
<option value="Driving Licence">Driving Licence</option>
<option value="Learner's Licence">Learner's Licence</option>
<option value="Issue of Duplicate Driving Licence ">Issue of Duplicate Driving Licence </option>
<option value="Permanent Licence">Permanent Licence</option>
<option value="Renewal Driving Licence">Renewal Driving Licence</option>
</select>
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
<select name="status">
<option value="Approved">Approved</option>
<option value="Pending">Pending</option>
<option value="Rejected">Rejected</option>
</select>
</div>

<button type="submit" class="btn btn-primary">Submit</button>
</form>
</div>
</div>
</div>

<c:import url="include/footer.jsp"></c:import>