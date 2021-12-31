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
			<core:choose>
				<core:when test="${action!=null}">
					<h1>Update Food</h1>
				</core:when>
				<core:otherwise>
					<h1>Add New Food</h1>
				</core:otherwise>
			</core:choose>
		</div>

		<div class="container">
		<core:if test="${action==null}">
			<form action="savefood" method="post" enctype="multipart/form-data">
		</core:if>
		<core:if test="${action!=null}">
			<form action="updatefood" method="post" enctype="multipart/form-data">
		</core:if>	
				<table class="table">
					<tr>
						<td colspan="2"></td>
						<core:if test="${msg!=null}">
							${msg}<br>
							Food Id ${foodId}
						</core:if>
					</tr>
					<core:if test="${action!=null}">
					<tr>
					<td><label class="font-weight-bold">Food Id :</label></td>
						<td><input readonly="readonly" class="form-control" name="foodId" value="${food.foodId}"></td>
					</tr>
					</core:if>
					<tr>
						<td><label class="font-weight-bold">Food Name :</label></td>
						<td><input class="form-control" type="text" name="foodName" value="${food.foodName}"></td>
					</tr>

					<tr>
						<td><label class="font-weight-bold">Food Category :</label></td>
						<td><input class="form-control" type="text"
							name="foodCategory" value="${food.foodCategory}"></td>
					</tr>
					<tr>
						<td><label class="font-weight-bold">Food Price :</label></td>
						<td><input class="form-control" type="text" name="foodPrice" value="${food.foodPrice}"></td>
					</tr>
					<tr>
						<td><label class="font-weight-bold">Food Description :</label></td>
						<td><input class="form-control" type="text" name="foodDescription" value="${food.foodDescription}"></td>
					</tr>
					<tr>
						<td><label class="font-weight-bold">Food Image :</label></td>
						<td><input class="form-control" type="file" name="file"></td>
					</tr>
					<tr>
						<td colspan="2" align="right"><input
							class="btn btn-outline-success btn-lg" type="submit"
							name="Add Food"> <input
							class="btn btn-outline-success btn-lg" type="reset" name="Clear"></td>
					</tr>
				</table>
			</form>
		</div>
	</section>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>