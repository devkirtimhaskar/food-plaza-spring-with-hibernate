<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>
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
			<h1>Food Menu</h1>
		</div>

		<div class="container">
		<core:if test="${!foodlist.isEmpty()}">
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
						<th>Name</th>
						<th>Category</th>
						<th>Price</th>
						<th>Food Description</th>
						<th>Image</th>
						<th colspan="2">Action</th>
					</tr>
				</thead>
				<core:forEach var="food" items="${foodlist}">
					<TR>
						<TD>${food.foodId}</TD>
						<TD>${food.foodName}</TD>
						<TD>${food.foodCategory}</TD>
						<TD>${food.foodPrice}</TD>
						<TD>${food.foodDescription}</TD>
						<TD><img src="foodimage?foodId=${food.foodId}" height="100" width="100"></TD>
						<TD><a
							onclick="return confirm('do you really want to delete this Food');"
							href="deletefood?foodId=${food.foodId}">Delete</a></TD>
						<TD><a onclick="return confirm('do you really want to edit this Food');"
							href="editfood?foodId=${food.foodId}">Edit</a></TD>
					</TR>
				</core:forEach>
			</table>
			</core:if>
			<core:if test="${foodlist.isEmpty()}">
				<h2>No Food Found</h2>
			</core:if>
		</div>
	</section>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>