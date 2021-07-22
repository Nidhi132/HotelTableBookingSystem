<%@include file="include/header.jsp" %>
<br/>
<div class="contact" id="mail">
		<div class="container">
			<div class="wthree-heading">
				<h3>Add Item</h3>
			</div>
			<div class="agile-contact-grids">
				<div class="col-md-6 agile-contact-left">
					<div class="contact-form">
						<h4>Add the item info</h4>
						<form action="menu" method="post">
							<div class="styled-input agile-styled-input-top">
								<input type="text" name="id" required>
								<label>Id</label>
								<span></span>
							</div>
							<div class="styled-input">
								<input type="text" name="name" required> 
								<label>Name</label>
								<span></span>
							</div>	
							<div class="styled-input">
								<input type="text" name="cost" required> 
								<label>Cost(Rs.)</label>
								<span></span>
							</div> 
								 
							<input type="submit" value="Add Item">
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