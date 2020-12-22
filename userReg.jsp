<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false" %>
<c:import url="include/header.jsp">
<c:param name="title" value="Registration Form"></c:param>
</c:import>

<div class="container mtb">
<div class="row">
<div class="col-lg-6">
<%
String msg = (String)request.getAttribute("msg");
if(msg!=null){
%>
<p style="color:green;"><%=msg %></p>
<%
}
%>

<h1>New Registration Form</h1>
<form action="UserController?page=ureg" method="post">
<div class="form-group">
<label>Select The Service You Are Looking For</label>
<select id="test" name="test" class="form-control">
<option value="Driving Licence">Driving Licence</option>
<option value="Learner's Licence">Learner's Licence</option>
<option value="Issue of Duplicate Driving Licence ">Issue of Duplicate Driving Licence </option>
<option value="Permanent Licence">Permanent Licence</option>
<option value="Renewal Driving Licence">Renewal Driving Licence</option>
</select>
</div>
<div class="form-group">
<label>Name</label>
<input type="text" name="name" id="name" required="required" class="form-control">
</div>
<div class="form-group">
<label>DOB</label>
<input type="date" name="dob" id="dob" required="required" class="form-control">
</div>
<div class="form-group">
<label>Age</label>
<input type="text" name="age" id="age" required="required" class="form-control">
</div>
<div class="form-group">
<label>Aadhar Card</label>
<input type="text" name="aadhar" id="aadhar" required="required" class="form-control">
</div>
<div class="form-group">
<label>Address</label>
<input type="text" name="address" id="address" required="required" class="form-control">
</div>
<div class="form-group">
<label>Mobile</label>
<input type="text" name="mobile" id="mobile" required="required" class="form-control">
</div>
<div class="form-group">
<label>Email</label>
<input type="email" name="email" id="email" required="required" class="form-control">
</div>
<div class="form-group">
<label>Gender</label>
<input type="radio" name="gender" id="gender" class="form-input-type" value="Male">Male
<input type="radio" name="gender" id="gender" class="form-input-type" value="FeMale">FeMale
</div>
<div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input type="password" name="password" class="form-control" id="password" required="required" placeholder="create password">
  </div>
  <div class="form-row">
    <div class="form-group col-md-6">
      <label for="inputCity">City</label>
      <input type="text" class="form-control" id="city" name="city">
    </div>
    <div class="form-group col-md-4">
      <label for="inputState">State</label>
      <select id="inputState" class="form-control" name="state" id="state">
        <option value="Maharashtra">Maharashtra</option>
        <option>...</option>
      </select>
    </div>
    <div class="form-group col-md-2">
      <label for="inputZip">Zip</label>
      <input type="text" class="form-control" id="zip" name="zip">
    </div>
  </div>
  
<button class="btn btn-primary" type="submit">Register</button>
</form>



</div>
</div>
</div>
<c:import url="include/footer.jsp"></c:import>