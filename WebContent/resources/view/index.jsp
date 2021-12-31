<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
    
<script type="text/javascript">
		$(function(){
				 $('li.nav-item').removeClass('active'); 
				 $("#home").addClass('active'); 
		});
	</script>

<jsp:include page="header.jsp"></jsp:include>	
	<!-- Page Content -->
	<section class="py-5">
	<core:if test="${msg!=null or emsg!=null}">
	<tr>
			<td colspan="6"><span class="success">${msg}</span> <span
			class="error">${emsg}</span></td>
	</tr>

	</core:if>
	
	  <div class="container">
	    <h1>Food Menu</h1>
	  </div>
	 <div class="foodcontainer">
		<core:forEach var="food" items="${foodlist}">
		<div class="food-card">
		<div class="food-header foodimage" style="background-image: url('foodimage?foodId=${food.foodId}');">
			<div class="header-icon-container">
				<a href="#">
					<i class="material-icons header-icon"> </i>
				</a>
			</div>
		</div>
		<!--food-header-->
		<div class="food-content">
			<div class="food-content-header">
				<a href="#">
					<h3 class="food-title">${food.foodName}</h3>
				</a>
			</div>
			<div class="food-info">
				<div class="info-section">
					<label>Category</label>
					<span>${food.foodCategory}</span>
				</div><!--Type-->
				<div class="info-section">
					<label>Price</label>
					<span>&#8377; ${food.foodPrice}</span>
				</div><!--Price-->
			</div>
			<div class="food-info">
				<div class="info-section">
					<label>Description</label>
					<span>${food.foodDescription}</span>
				</div><!--description-->
			</div>
			<div  class="food-info">
				<div  class="info-section" style="text-align:right;" >
				<core:if test="${admin==null}">
					<a class="btn btn-primary ml-auto" href="addtocart?foodId=${food.foodId}" role="button">Add to Cart</a>
				</core:if>
				
				<core:if test="${admin!=null}">
				<a onclick="return confirm('do you really want to edit this Food');"
							href="editfood?foodId=${food.foodId}">Edit</a>
				<a	onclick="return confirm('do you really want to delete this Food');"
							href="deletefood?foodId=${food.foodId}">Delete</a>
				</core:if>
				</div>
			</div>
		</div><!--food-content-->
	</div>
	</core:forEach>
	  </div>
	</section>
	
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>