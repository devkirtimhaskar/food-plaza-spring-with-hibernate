<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	
	<section class="py-5">
		<div class="container">
			<h1>Order Details</h1>
		</div>

		<div class="container">
		<h3>${msg}</h3>
		${order}<br>
		
		<h1></h1>
		</div>
		</section>
		
	
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>