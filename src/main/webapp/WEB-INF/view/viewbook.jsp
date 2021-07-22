<%@include file="include/header.jsp" %>
<%@ page import="java.util.List" %>
<%@ page import="org.jss.controller.*" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<br/>
<div class="contact" id="mail">
		<div class="container">
			<div class="wthree-heading">
			<h3>Today's Booking Info</h3>
			
			<div class="container mtb">
	<div class="row">
		<div style="padding:20px">
			<hr />
			
			<table class="table table-striped table-dark">
				<thead>
					<td><strong>ID</strong></td>
					<td><strong>Email</strong></td>
					<td><strong>Date</strong></td>
					<td><strong>Time-slot</strong></td>
					<td><strong>Number of people</strong></td>
				</thead>
				<tbody>
      <c:forEach items="${book}" var="book">
        <tr>
          <td>${book.idbook}</td>
          <td>${book.email}</td>
          <td>${book.date}</td>
          <td>${book.time_slot}</td>
          <td>${book.nop}</td>
		</tr>
      </c:forEach>
  </tbody>
			</table>
		</div>
	</div>
			</div>
		</div>
</div>
</div>
</div>
<%@include file="include/footer.jsp" %>