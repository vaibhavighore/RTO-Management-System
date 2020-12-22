<%@page import="code.microsystem.Service.AdminService"%>
<%@page import="code.microsystem.Entity.User"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url="include/adminHeader.jsp">
<c:param name="title" value="View All User"></c:param>
</c:import>


<%
List<User> allUser = AdminService.viewAllDetails();
int sno = 1;
%>

<div class="container mtb">
<div class="row">
<div class="col-lg-12">
<h2>View All User Details</h2>
<table class="table table-striped">
<thead>
<tr>
<th scope="col">Sr. No.</th>
<th scope="col">Registration Id</th>
<th scope="col">Test</th>
<th scope="col">Name</th>
<th scope="col">DOB</th>
<th scope="col">Age</th>
<th scope="col">Aadhar Card</th>
<th scope="col">Address</th>
<th scope="col">Mobile</th>
<th scope="col">Email</th>
<th scope="col">Gender</th>
<th scope="col">Password</th>
<th scope="col">City</th>
<th scope="col">State</th>
<th scope="col">Pin Code</th>
<th>Date</th>
<th scope="col">Delete</th>
</tr>
</thead>

<tbody>
<c:forEach var="user" items="<%=allUser %>">
<tr>
<td><%=sno++ %></td>
<td scope="row">${user.id}</td>
<td scope="row">${user.test}</td>
<td scope="row">${user.name}</td>
<td scope="row">${user.dob}</td>
<td scope="row">${user.age}</td>
<td scope="row">${user.aadhar}</td>
<td scope="row">${user.address}</td>
<td scope="row">${user.mobile}</td>
<td scope="row">${user.email}</td>
<td scope="row">${user.gender}</td>
<td scope="row">${user.password}</td>
<td scope="row">${user.city}</td>
<td scope="row">${user.state}</td>
<td scope="row">${user.zip}</td>
<td>${user.created}</td>

<td scope="row" ><a href="AdminController?page=udelete&id=${user.id}" class="btn btn-primary" onclick="if(!(confirm('Are you sure you want to delete this record'))) return false">Delete</a></td>
</tr>
</c:forEach>
</tbody>
</table>
</div>
</div>
</div>

<c:import url="include/footer.jsp"></c:import>