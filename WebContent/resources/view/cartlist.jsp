<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart List</title>
<script type="text/javascript">
	$(function() {
		$('li.nav-item').removeClass('active');
		$("#cartlist").addClass('active');
	});
</script>

</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>

	<section class="py-5">
		<form action="placeorder" method="post">
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
							<th>Cart Id</th>
							<th>Food Image</th>
							<core:if test="${admin!=null}">
								<th>Customer Email Id</th>
							</core:if>
							<th>Food Name</th>
							<th>Food Quantity</th>
							<th>Food Price</th>
							<th colspan="2">Action</th>
						</tr>
					</thead>
					<core:forEach var="cart" items="${cartlist}">
						<TR>
							<TD>${cart.cartId}</TD>
							<td><img src="foodimage?foodId=${cart.foodId}" width="100" height="100"></td>
							<core:if test="${admin!=null}">
							<TD>${cart.cartCustEmailId}</TD>
							</core:if>
							
							<TD>${cart.foodName}</TD>
							<TD><input type="number" class="qty" name="cartFoodQuantity" class="qty" value="${cart.cartFoodQuantity}"><input type="hidden" name="cartId" value="${cart.cartId}" readonly="readonly"></TD>
							<TD><input type="number" id="" class="price" name="foodPrice" class="price" value="${cart.foodPrice}" readonly="readonly"></TD>
							<TD><a class="btn btn-primary ml-auto"
								onclick="return confirm('do you really want to delete this Food');"
								href="deletecart?cartId=${cart.cartId}">Delete</a></TD>
						</TR>
					</core:forEach>
					<tfoot>
						<tr>
						<script type="text/javascript">
						
						$(function(){
						function calcTotalAmount()
						{
							var qtylist = $(".qty");
							var pricelist = $(".price");
							var totalAmount = 0;
							$.each(qtylist,function(index,qty){
								totalAmount +=qty.value*pricelist[index].value;
							});
						//	$("#totalPrice").text(totalAmount);//when we are using span tage we should use thus to set value
							$("#totalPrice").val(totalAmount);
						}
						
						//handle click event on qty change
						
						$(".qty").click(function(){
							
							//it should be change while qty change
							calcTotalAmount();
							
							//to update changes on db
							var cartQty = this.value;
							var cartId = this.nextSibling.value;
							
							//$.post(url,data,takeresponsecallbackfunction)
							$.post("updateCartQty",{"cartId":cartId,"cartQty":cartQty},function(response){
								alert(response);
							});
							
						});
						
						//it should be call at a time of page loading or referesh
						calcTotalAmount();
						});
						</script>
							<td colspan="3" >Total Price</td>
							<td colspan="2">&#8377<input type="text" id="totalPrice" name="totalPrice" readonly="readonly"></td><!-- this &#8377 code is used for Rs symbol -->
							<td colspan="1"><input  class="btn btn-primary ml-auto"  type="submit" value="Place Order"></td>
						</tr>
					</tfoot>
				</table>
			</core:if>
			<core:if test="${foodlist.isEmpty()}">
				<h2>No Food Found</h2>
			</core:if>
		</div>
		</form>
	</section>

	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>