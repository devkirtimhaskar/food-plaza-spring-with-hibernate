<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Food</title>
<script type="text/javascript">
	$(function() {
		$('li.nav-item').removeClass('active');
		$("#addfood").addClass('active');
	});
</script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<section class="py-5">
		<div class="container">
			<h1>Customer List</h1>
		</div>

		<div class="container">
		<core:if test="${!custlist.isEmpty()}">
			<table class="table">
			<thead class="thead-dark">
					<core:if test="${msg!=null or emsg!=null}">
						<tr>
							<td colspan="6"><span class="success">${msg}</span> <span
								class="error">${emsg}</span></td>
						</tr>

					</core:if>
				<tr>
					<th>Id</th>
					<th>Email Id</th>
					<th>Password</th>
					<th>Contact Number</th>
					<th>address</th>
					<th colspan="2">Action</th>
				</tr>
				<core:forEach var="cust" items="${custlist}">
					<TR>
						<TD>${cust.custId}</TD>
						<TD>${cust.custEmail}</TD>
						<TD>${cust.custPassword}</TD>
						<TD>${cust.contactNumber}</TD>
						<TD>${cust.address}</TD>
						<TD><a onclick="return confirm('do you really want to delete this Customer');" 
							href="deletecust?custId=${cust.custId}">Delete</a></TD>
						<TD><a onclick="return confirm('do you really want to Edit this Customer');" 
						href="editcust?custId=${cust.custId}">Edit</a></TD>
					</TR>
				</core:forEach>
			</table>
			</core:if>
		</div>
	</section>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>