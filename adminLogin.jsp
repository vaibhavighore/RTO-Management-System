<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="include/header.jsp">
<c:param name="title" value="Admin Login"></c:param>
</c:import>
<div class="container mtb">
<div class="row">
<div class="col-lg-6">
<%
String msg = (String)request.getAttribute("msg");
if(msg!=null){
%>
<p style="color:red;"><%=msg %></p>
<%} %>
<h1>Admin Login</h1>
<form action="AdminController?page=alogin" method="post">
  <div class="form-group">
    <label for="exampleInputEmail1">Email address</label>
    <input type="email" class="form-control" id="email" name="email" aria-describedby="emailHelp" placeholder="Email address" required="required">
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" name="password" class="form-control" id="password" required="required" placeholder="password">
  </div>
  
  <button type="submit" class="btn btn-primary">Submit</button>		|		 <button type="reset" class="btn btn-danger">Cancel</button>

</form>
</div>
</div>
</div>
<c:import url="include/footer.jsp"></c:import>