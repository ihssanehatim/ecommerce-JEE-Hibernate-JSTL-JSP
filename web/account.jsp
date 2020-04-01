<!DOCTYPE html>
<jsp:include page="header.jsp"/>

		<div id="breadcrumb" class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">
					<div class="col-md-12">
						
						<ul class="breadcrumb-tree">
							<label for="create-account">
										<span></span>
										Sign in
									</label>
							
						</ul>
					</div>
				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- /BREADCRUMB -->

		<!-- SECTION -->
		<div class="section">
			<!-- container -->
			<div class="container">
				<!-- row -->
				<div class="row">
                                    <div class="col-md-6">
                                 
                                       
                                       <div class="form-group">
								
                                           <form action="/ecommerce/Authentif" method="post">			
									
									<div class="caption">
										<p>Please fill the form :</p>
										<input class="input" type="text" name="username" placeholder="Enter Your Username" required>
                                                                                <input class="input" type="password" name="password" placeholder="Enter Your Password" required>
									</div>
								<div class="row">
					
						
						<div class="newsletter">
							
                                                  		
                                                          <button class="newsletter-btn"><i class="fa fa-sign-in"></i> Sing In</button>
                                                     
							
							
                                                </div>
                                          
				</div>
					 </form>		</div>
                                       
                                 
                                    </div>
				</div>
				<!-- /row -->
			</div>
			<!-- /container -->
		</div>
		<!-- /SECTION -->
                <jsp:include page="footer.jsp"/>