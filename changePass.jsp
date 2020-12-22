<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:import url = "include/userHeader.jsp">
<c:param name="title" value="Change Password"></c:param>
</c:import>

<div class="container mtb">
<div class="row">
<div class="col-lg-6">
<h2>Change Password Details</h2>
<%
String email = (String)session.getAttribute("email");
%>
<h2>Welcome <%=email %></h2>
<form action="UserController?page=changePass">
<div class="form-group">
<label>New Password</label>
<input class="form-control" name="password" id="password">
</div>
<div class="form-group">
<label>Confirm Password</label>
<input class="form-control" name="conpassword" id="conpassword">
</div>
<button type="submit" class="btn btn-primary">Submit</button>
</form>
</div>
</div>
</div>

<c:import url="include/footer.jsp"></c:import>