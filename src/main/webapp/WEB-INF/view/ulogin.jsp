<%@include file="include/header1.jsp" %>
<br/>
<div class="contact" id="mail">
		<div class="container">
			<div class="wthree-heading">
				<h3>Login</h3>
			</div>
			<div class="agile-contact-grids">
				<div class="col-md-6 agile-contact-left">
					<div class="contact-form">
						<h4>Login form</h4>
						<form action="userlog" method="post">
							<div class="styled-input agile-styled-input-top">
								<input type="email" name="email" required>
								<label>Email</label>
								<span></span>
							</div>
							<div class="styled-input">
								<input type="password" name="password" required> 
								<label>Password</label>
								<span></span>
							</div> 
								 
							<input type="submit" value="Login">
							<br>
							<div class="w3-button">
							If you are new, please
							<a href="${pageContext.request.contextPath}/usignup">Signup</a>
							</div>
						</form>
					</div>
				</div>
				<div class="col-md-6 agile-contact-right">
					<div class="agileits-map">
					</div>
					<div class="map-grid">
					</div>
				</div>
				<div class="clearfix"> </div>
			</div>
		</div>
	</div>
	<!-- //contact -->
</div>
</div>
<%@include file="include/footer.jsp" %>