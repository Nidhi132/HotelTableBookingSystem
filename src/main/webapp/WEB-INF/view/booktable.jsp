<%@include file="include/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.time.LocalTime" %>
<br/>
<div class="contact" id="mail">
		<div class="container">
			<div class="wthree-heading">
				<h3>Book table</h3>
			</div>
			<c:if test="${sessionScope.time > sessionScope.time5}">
			<div class="agile-contact-grids">
				<div class="col-md-6 agile-contact-left">
					<div class="contact-form">
						<h4>Book a table for today!!</h4>
						</div>
						
						<form action="book" method="post">
							<div class="styled-input agile-styled-input-top">
								<input type="email" name="email" required>
								<label>Email</label>
								<span></span>
							</div>
							<div class="styled-input">
								<input type="number" name="nop" required> 
								<label>Number of people</label>
								<span></span>
							</div>
							<div class="styled-input">
								<span>Time-Slot</span>
							
							<c:choose> 
							<c:when test="${sessionScope.time <= sessionScope.time1}">
							<div class="styled-input">
							<select class="w3-select" id="time_slot" name="time_slot" required>
							<option value="" disabled selected>Choose time-slot</option>
							<option value="Breakfast">Breakfast</option>
							<option value="Brunch">Brunch</option>
							<option value="Lunch">Lunch</option>
							<option value="Tea-Snacks">Tea-Snacks</option>
							<option value="Dinner">Dinner</option>
							</select>
							</div>
							</c:when>
							
							<c:when test="${sessionScope.time <= sessionScope.time2}">
							<div class="styled-input">
							<select class="w3-select" id="time_slot" name="time_slot" required>
							<option value="" disabled selected>Choose time-slot</option>
							<option value="Brunch">Brunch</option>
							<option value="Lunch">Lunch</option>
							<option value="Tea-Snacks">Tea-Snacks</option>
							<option value="Dinner">Dinner</option>
							</select>
							</div>
							</c:when>
							
							<c:when test="${sessionScope.time <= sessionScope.time3}">
							<div class="styled-input">
							<select class="w3-select" id="time_slot" name="time_slot" required>
							<option value="" disabled selected>Choose time-slot</option>
							<option value="Lunch">Lunch</option>
							<option value="Tea-Snacks">Tea-Snacks</option>
							<option value="Dinner">Dinner</option>
							</select>
							</div>
							</c:when>
							
							<c:when test="${sessionScope.time <= sessionScope.time4}">
							<div class="styled-input">
							<select class="w3-select" id="time_slot" name="time_slot" required>
							<option value="" disabled selected>Choose time-slot</option>
							<option value="Tea-Snacks">Tea-Snacks</option>
							<option value="Dinner">Dinner</option>
							</select>
							</div>
							</c:when>
							
							<c:when test="${sessionScope.time > sessionScope.time4}">
							<div class="styled-input">
							<select class="w3-select" id="time_slot" name="time_slot" required>
							<option value="" disabled selected>Choose time-slot</option>
							<option value="Dinner">Dinner</option>
							</select>
							</div>
							</c:when>
							</c:choose>
							</div>
							
							<input type="submit" value="Book">
						</form>
					</div>
				</div>
				</c:if>
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