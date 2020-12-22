<%@page import="code.microsystem.Service.UserService"%>
<%@page import="code.microsystem.Entity.User"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<c:import url="include/userHeader.jsp" >

<c:param name="title" value="Update Employee"/>
</c:import>


<div class="container mtb">
<div class="row">
<div class="col-lg-6">
<h1>Update Profile </h1>
<%
String msg = (String)request.getAttribute("email");
String email = (String)session.getAttribute("email");
User u = UserService.changePro(email);
if(msg!=null){
%>
<p style="color:green"><%=msg %></p>
<%} %>
Welcome <%=email %>
<c:set var="u" value="<%=u %>"></c:set>

<form action="UserController?page=updateProfile" method="post">
<div class="form-group">
<label>Registered Id</label>
<input type="text" name="id" id="id" readonly="readonly" class="form-control"  value="<%=u.getId()%>">
</div>

<div class="form-group">
<label>Select The Service You Are Looking For</label>
<input type="text" name="test" id="test" readonly="readonly" class="form-control"  value="<%=u.getTest()%>">
</div>
<div class="form-group">
<label>Name</label>
<input type="text" name="name" id="name" required="required" class="form-control"  value="<%=u.getName()%>">
</div>
<div class="form-group">
<label>DOB</label>
<input type="date" name="dob" id="dob" required="required" class="form-control"  value="<%=u.getDob()%>">
</div>
<div class="form-group">
<label>Age</label>
<input type="text" name="age" id="age" required="required" class="form-control"  value="<%=u.getAge()%>">
</div>
<div class="form-group">
<label>Aadhar Card</label>
<input type="text" name="aadhar" id="aadhar" required="required" class="form-control"  value="<%=u.getAadhar()%>">
</div>
<div class="form-group">
<label>Address</label>
<input type="text" name="address" id="address" required="required" class="form-control"  value="<%=u.getAddress()%>">
</div>
<div class="form-group">
<label>Mobile</label>
<input type="text" name="mobile" id="mobile" required="required" class="form-control"  value="<%=u.getMobile()%>">
</div>
<div class="form-group">
<label>Email</label>
<input type="email" name="email" id="email" required="required" class="form-control"  value="<%=u.getEmail()%>">
</div>
<div class="form-group">
<label>Gender</label>
<input type="radio" name="gender" id="gender" class="form-input-type" value="Male">Male
<input type="radio" name="gender" id="gender" class="form-input-type" value="FeMale">FeMale
</div>
<div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="text" name="password" class="form-control" id="password"  value="<%=u.getPassword()%>" required="required">
  </div>
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputCity">City</label>
      <input type="text" class="form-control" id="city" name="city"  value="<%=u.getCity()%>">
    </div>
    <div class="form-group col-md-4">
      <label for="inputState">State</label>
      <select id="inputState" class="form-control" name="state" id="state"  value="<%=u.getState()%>">
        <option value="Maharashtra">Maharashtra</option>
        <option>...</option>
      </select>
    </div>
    <div class="form-group col-md-2">
      <label for="inputZip">Zip</label>
      <input type="text" class="form-control" id="zip" name="zip"  value="<%=u.getZip()%>">
    </div>
  </div>
  
<button class="btn btn-primary text-secondary" type="submit">Update</button>
</form>

</div>
</div>
</div>
<c:import url="include/footer.jsp" />