<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false" %>
<c:import url="include/userHeader.jsp">
<c:param name="title" value="Payment "></c:param>
</c:import>

<div class="container mtb">
<div class="row">
<div class="col-lg-6">
<h1>Payment</h1>
<form action="UserController?page=payment" method="post">
 <div class="form-group">
        <label for="fname">Accepted Cards</label>
            <div class="icon-container">
              <i class="fa fa-cc-visa" style="color:navy;"></i>
              <i class="fa fa-cc-amex" style="color:blue;"></i>
              <i class="fa fa-cc-mastercard" style="color:red;"></i>
              <i class="fa fa-cc-discover" style="color:orange;"></i>
            </div>
       </div>
       
       <div class="form-group">
       <label>Name on Cards</label>
       <input type="text" name="name" id="name" class="form-control" placeholder="Name on Cards">
       </div>
       
         <div class="form-group">
       <label>Payment</label>
      <select name="pay" id="pay">
      <option value="Rs. 399">Rs. 399</option>
      </select>
       </div>
       
       <div class="form-group">
       <label>Credit Card Number</label>
       <input type="text" id="cardno" name="cardno" placeholder="1111-2222-3333-4444" class="form-control">
       </div>
       
  <div class="form-row">
    <div class="form-group col-md-6">
      <label>Expiry Month</label>
       <input type="text" id="mon" name="mon"  class="form-control" placeholder="Expiry Month">
    </div>
    <div class="form-group col-md-4">
       <label>Expiry Year</label>
       <input type="text" id="year" name="year"  class="form-control" placeholder="Expiry Year">
    </div>
    <div class="form-group col-md-2">
      <label>CVV</label>
       <input type="text" id="cvv" name="cvv"  class="form-control" placeholder="CVV">
    </div>
  </div>
  
<button class="btn btn-primary" type="submit">Submit</button>
</form>



</div>
</div>
</div>
<c:import url="include/footer.jsp"></c:import>