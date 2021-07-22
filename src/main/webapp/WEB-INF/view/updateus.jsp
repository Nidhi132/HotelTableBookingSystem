<%@include file="include/header.jsp" %>
<br/>
<div class="contact" id="mail">
		<div class="container">
			<div class="wthree-heading">
				<h3>Update</h3>
			</div>
			<div class="agile-contact-grids">
				<div class="col-md-6 agile-contact-left">
					<div class="contact-form">
						<h4>Update form</h4>
						<%
						Object ob = session.getAttribute("email");
			        	 String email = (String)ob;
				%>
						<form action="userupdate" method="post">
							<div class="styled-input agile-styled-input-top">
								<span>Email is ${email}</span>
								<span></span>
							</div>
							<div class="styled-input">
								<input type="text" name="name" value="${user.name}" required> 
								<label>Name</label>
								<span></span>
							</div>
							<div class="styled-input">
								<input type="text" name="phone" value="${user.phone}" required> 
								<label>Phone number</label>
								<span></span>
							</div>
							<div class="styled-input">
								<input type="password" name="password" value="${user.password}" required> 
								<label>Password</label>
								<span></span>
							</div> 
								 
							<input type="submit" value="Update">
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