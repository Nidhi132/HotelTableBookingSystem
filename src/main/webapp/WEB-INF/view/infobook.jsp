<%@include file="include/header.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<br/>
<div class="contact" id="mail">
		<div class="container">
			<div class="wthree-heading">
			<h3>Your Today's Booking info</h3>
			
			<div class="container mtb">
	<div class="row">
		<div style="padding:20px">
			<hr />
			
			<table class="table table-striped table-dark">
				<thead>
					<td><strong>ID</strong></td>
					<td><strong>Time-slot</strong></td>
					<td><strong>Number of people</strong></td>
				</thead>
				<tbody>
      <c:forEach items="${book}" var="book">
        <tr>
          <td>${book.idbook}</td>
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
		
				<br/>
		<div class="wthree-heading">
			<h3>Edit</h3>
		<div class="agile-contact-grids">
				<div class="col-md-6 agile-contact-left" style="border:2px solid black;">
					<div class="contact-form">
						<h4>Select ID and edit</h4>
						<form method="post">
							<div class="styled-input agile-styled-input-top">
								 <!-- <span>ID</span> -->
								 <select class="w3-select" name="idbook" style="width:100px;">
								 <option value="" disabled selected>Choose id</option>
                                 <c:forEach items="${book}" var="book">
                                 <option value="${book.idbook}">${book.idbook}</option>
                                </c:forEach>
                             </select>
                             <lable>ID</lable>
                            </div>
<input type="submit" formaction="delbook" value="Delete" onclick="if(!confirm('Are you sure to delete the booking?')) return false" style="float:right; margin:10px;">
<input type="submit" formaction="bookup" value="Update" style="float:left; margin:10px;">
</form>
</div>
</div>
</div>
</div>
</div>
</div>
</div>
<%@include file="include/footer.jsp" %>