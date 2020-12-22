<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:import url="include/adminHeader.jsp">
<c:param name="title" value="Admin Home"></c:param>
</c:import>

<div class="container mtb">
<div class="row">
<div class="col-lg-6">
<%
String email = (String)session.getAttribute("email");
%>
<h2>Welcome Admin</h2>
</div>
</div>
</div>
<c:import url="include/footer.jsp"></c:import>