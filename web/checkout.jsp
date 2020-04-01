<jsp:include
    page="header.jsp" />
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
		<!-- BREADCRUMB -->
		<div id="breadcrumb" class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">
					<div class="col-md-12">
						<h3 class="breadcrumb-header">Checkout</h3>
						<ul class="breadcrumb-tree">
							<li><a href="#">Home</a></li>
							<li class="active">Checkout</li>
						</ul>
					</div>
				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- /BREADCRUMB -->

		<!-- SECTION -->
                  <form method="post" action="/ecommerce/passerCommande">
		<div class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">

					<div class="col-md-7">
						<!-- Billing Details -->
                                              
                                                    
						<div class="billing-details">
							<div class="section-title">
								<h3 class="title">Shipping address</h3>
							</div>
							<div class="form-group">
                                                            <input class="input" type="text" name="fn" placeholder="First Name" required >
							</div>
							<div class="form-group">
								<input class="input" type="text" name="ln" placeholder="Last Name"  required>
							</div>
							
							<div class="form-group">
								<input class="input" type="number" name="house" placeholder="House Number"  required>
							</div>
							<div class="form-group">
								<input class="input" type="text" name="city" placeholder="City"  required>
							</div>
							<div class="form-group">
								<input class="input" type="text" name="country" placeholder="Country"   required>
							</div>
							<div class="form-group">
								<input class="input" type="text" name="street" placeholder="street"   required>
							</div>
							
							<div class="form-group">
								
									<label for="create-account">
										<span></span>
                                                                                <% if( request.getSession().getAttribute("username") == null ){ %>
										Sign in or Create Account
                                                                                <% }else { %>
                                                                                Retype Your Login and Password :
                                                                                <%}%>
                                                                                
									</label>
									<div class="caption">
										<p>Please fill the form :</p>
										<input class="input" type="text" name="username" placeholder="Enter Your Username" >
                                                                                <input class="input" type="password" name="password" placeholder="Enter Your Password" >
									</div>
								
							</div>
						</div>
						<!-- /Billing Details -->

						<!-- Shiping Details -
						<div class="shiping-details">
							<div class="section-title">
								<h3 class="title">Shipping address</h3>
							</div>
							<div class="input-checkbox">
								<input type="checkbox" id="shiping-address" name="todo" value="address">
								<label for="shiping-address">
									<span></span>
									Ship to a different address?
								</label>
								<div class="caption">
									
									
									<div class="form-group">
										<input class="input" type="number" name="house2" placeholder="House Number" >
									</div>
									<div class="form-group">
										<input class="input" type="text" name="city2" placeholder="City">
									</div>
									<div class="form-group">
										<input class="input" type="text" name="country2" placeholder="Country">
									</div>
									<div class="form-group">
										<input class="input" type="text" name="street2" placeholder="street">
									</div>
									
								</div>
							</div>
						</div>
						<!-- /Shiping Details -->

						<!-- Order notes -
						<div class="order-notes">
							<textarea class="input" placeholder="Order Notes"></textarea>
						</div>
						<!-- /Order notes -->
					</div>

					<!-- Order Details -->
					<div class="col-md-5 order-details">
						<div class="section-title text-center">
							<h3 class="title">Your Order</h3>
						</div>
						<div class="order-summary">
							<div class="order-col">
								<div><strong>PRODUCT</strong></div>
								<div><strong>TOTAL</strong></div>
							</div>
                                                      <c:forEach items="${sessionScope.MAP}" var="entry" >
							<div class="order-products">
                                                            
                                                          
                                                            
								<div class="order-col">
									<div><c:out value="${entry.value}"/>x <c:out value="${entry.key.label}"/>(<c:out value="${entry.key.price}"/>/UNIT)</div>
									<div><c:out value="${entry.value  * entry.key.price }"/></div>
								</div>
                                                         
                                                           
							</div>
                                                        </c:forEach>
							<div class="order-col">
								<div>Shipping</div>
								<div><strong>FREE</strong></div>
							</div>
							<div class="order-col">
								<div><strong>TOTAL</strong></div>
                                                                <div><strong class="order-total"><c:out value="${sessionScope.price}" /> MAD</strong></div>
							</div>
						</div>
						<div class="payment-method">
							<div class="input-radio">
								<input type="radio" name="payment" id="payment-1">
								<label for="payment-1">
									<span></span>
									Direct Bank Transfer
								</label>
								
							</div>
							<div class="input-radio">
								<input type="radio" name="payment" id="payment-2">
								<label for="payment-2">
									<span></span>
									Cheque Payment
								</label>
								
							</div>
							<div class="input-radio">
								<input type="radio" name="payment" id="payment-3">
								<label for="payment-3">
									<span></span>
									Paypal System
								</label>
								
							</div>
						</div>
						<div class="input-checkbox">
							<input type="checkbox" id="terms">
							<label for="terms">
								<span></span>
								I've read and accept the <a href="#">terms & conditions</a>
							</label>
						</div>
                                            <button class="primary-btn order-submit"  >Place Order</button>
                                            <button class="primary-btn order-submit" onclick="document.location='/ecommerce/cart'" >Update Order</button>
					</div>
					<!-- /Order Details -->
				</div>
                                
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
             </form>

		<!-- /SECTION -->

                <jsp:include page="footer.jsp"/>