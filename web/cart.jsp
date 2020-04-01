<%-- 
    Document   : cart
    Created on : Mar 30, 2020, 5:22:02 PM
    Author     : ihssane
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include
    page="header.jsp" />
 <c:forEach items="${sessionScope.MAP}" var="entry" varStatus="theCount">
     
     

			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">
                                      
						
                                                                                    
                                                         
											
                                                   <div class="col-md-12">                                                	<!-- Product details -->
                                                       
                                                                                                       
						<div class="product-details" style="padding-top: 20px;">
							<h2 class="product-name"><c:out value="${entry.key.label}"/></h2>
							<div>
								<div class="product-rating">
									<i class="fa fa-star"></i>
									<i class="fa fa-star"></i>
									<i class="fa fa-star"></i>
									<i class="fa fa-star"></i>
									<i class="fa fa-star-o"></i>
								</div>
								
							</div>
							<div>
								<h3 class="product-price"> <c:out value="${entry.key.price}"/> MAD</h3>
                                                              
                                                                
							</div>
                                                      
						
                                                                <form action="/ecommerce/cart?id=<c:out value="${entry.key.idProd}"/>&nbre=<c:out value="${theCount.count}"/>" method="post">
                                                                    
							<div class="add-to-cart">
								<div class="qty-label">
									Qty
									<div class="input-number" >
                                                                            
                                                                            <input name="qte" type="number" value='<c:out value="${entry.value}" />' min='1' >
										<span class="qty-up">+</span>
										<span class="qty-down">-</span>
									</div>
								</div>
                                                                                <button class="add-to-cart-btn" name="act" value="update"><i class="fa fa-shopping-cart"></i>Update</button>
                                                                                <button class="add-to-cart-btn" name="act" value="delete"><i class="fa fa-shopping-cart"></i>Delete</button>
							</div>
                                                                </form>
                                                </div>
                                        </div>
                                                                                   </div>
                                                                
                                </div>
                     
     
                                                                                 </c:forEach>
										
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">
                                        <div class="col-md-12">
										
                                                                                  
                                                                                    
                                                                                   
                                                                                        <div>
                                                                                        <h3 class="product-price" >TOTAL : 
                                                                                           
                                                                                            <c:out value="${sessionScope.price}" /> MAD 
                                                                                           
                                                                                          
                                                                                           
                                                                                            
                                                                                            
                                                                                        </h3>
                                                                                        </div>
                                                                                    
                                                                                </div>
                                </div>
                        </div>
                                             
										
  <jsp:include page="footer.jsp"/>