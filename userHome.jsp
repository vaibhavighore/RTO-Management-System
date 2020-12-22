<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="include/userHeader.jsp">
<c:param name="title" value="User Home"></c:param>
</c:import>

<div class="container mtb">
<div class="row">
<div class="col-lg-6">

<%
String email = (String)session.getAttribute("email");
%>
<h2>Welcome <%=email %></h2>
</div>
</div>
</div>
<c:import url="include/footer.jsp"></c:import>