<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="include/userHeader.jsp">
<c:param name="title" value="Check Password Page"></c:param>
</c:import>
<div class="container mtb">
<div class="row">
<div class="col-lg-6">
<h2>Change Password</h2>
<form class="UserController?page=checkPass" method="post">
<div class="form-group">
<label>Enter your Email Address</label>
<input type="email" name="cemail" id="cemail" placeholder="Email Address">
</div>
<button class="btn btn-danger">Check</button>
</form>
</div>
</div>
</div>
<c:import url="include/footer.jsp"></c:import>