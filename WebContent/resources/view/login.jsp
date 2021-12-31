<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Customer</title>
<script type="text/javascript">
	$(function() {
		$('li.nav-item').removeClass('active');
		$("#addcustomer").addClass('active');
	});
</script>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<section class="py-5">
		<div class="container">
			<h1>Login Form</h1>
		</div>
		<div class="container">
		<form action="dologin" method="post">
				<table class="table">
				<tr>
						<td colspan="2"></td>
						<core:if test="${msg!=null}">
							${msg}<br>
						</core:if>
					</tr>
					<tr>
						<td><label class="font-weight-bold">User Type :</label></td>
						<td>
							<select class="form-control" name="usertype">
								<option value="">Select</option>
								<option value="admin">Admin</option>
								<option value="customer">Customer</option>
							</select>
						</td>
					</tr>
					<tr>
						<td><label class="font-weight-bold">Customer Email Id :</label></td>
						<td><input class="form-control" type="text" name="emailId"></td>
					</tr>

					<tr>
						<td><label class="font-weight-bold">Customer Password :</label></td>
						<td><input class="form-control" type="password" name="password"></td>
					</tr>
					<tr>
					<td colspan="2" align="right">
						<a href="addcustomer.jsp"><h3>Not registered yet? Register Now </h3></a>
					</td>		 
					</tr>
					<tr>
						<td colspan="2" align="right">
							<input class="btn btn-outline-success btn-lg" type="submit" value="Login"> 
							<input class="btn btn-outline-success btn-lg" type="reset" value="Cancel">
						</td>
					</tr>
				</table>
			</form>
		</div>
	</section>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>