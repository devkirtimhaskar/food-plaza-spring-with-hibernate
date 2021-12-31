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
		<core:choose>
				<core:when test="${action!=null}">
					<h1>Update Customer</h1>
				</core:when>
				<core:otherwise>
					<h1>Registration Form</h1>
				</core:otherwise>
		</core:choose>
		</div>

		<div class="container">
			<core:if test="${action==null}">
			<form action="savecustomer" method="post">
			</core:if>
			<core:if test="${action!=null}">
			<form action="updatecustomer" method="post">
			</core:if>
				<table class="table">
					<tr>
						<td colspan="2"></td>
						<core:if test="${msg!=null}">
							${msg}<br>
							Customer Id ${custId}
						</core:if>
					</tr>
					<core:if test="${action!=null}">
					<tr>
						<td><label class="font-weight-bold">Customer  Id :</label></td>
						<td><input readonly="readonly" class="form-control" type="number" name="custId" value="${cust.custId}"></td>
					</tr>
					</core:if>
					<tr>
						<td><label class="font-weight-bold">Customer Email Id :</label></td>
						<td><input class="form-control" type="text" name="custEmail" value="${cust.custEmail}"></td>
					</tr>

					<tr>
						<td><label class="font-weight-bold">Customer Password :</label></td>
						<td><input class="form-control" type="text"
							name="custPassword" value="${cust.custPassword}"></td>
					</tr>
					<tr>
						<td><label class="font-weight-bold">Contact Number :</label></td>
						<td><input class="form-control" type="number" name="contactNumber" value="${cust.contactNumber}"></td>
					</tr>
					
					<tr>
						<td><label class="font-weight-bold">Customer Address :</label></td>
						<td><input class="form-control" type="text" name="address" value="${cust.address}"></td>
					</tr>
					<tr>
						<td colspan="2" align="right"><input
							class="btn btn-outline-success btn-lg" type="submit"
							value="Add Customer"> <input
							class="btn btn-outline-success btn-lg" type="reset" value="Clear"></td>
					</tr>
				</table>
			</form>
		</div>
	</section>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>