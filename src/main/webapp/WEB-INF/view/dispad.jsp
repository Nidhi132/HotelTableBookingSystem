<%@include file="include/header.jsp" %>
<br/>
<div class="contact" id="mail">
		<div class="container">
			<div class="wthree-heading">
			<h3>Your Info</h3>
			
			<div class="container mtb">
	<div class="row">
		<div style="padding:20px">
			<hr />
			
			<table class="table table-striped table-dark">
				<thead>
					<td><strong>Name</strong></td>
					<td><strong>Password</strong></td>
				</thead>
				<tbody>
      <c:forEach items="${admin}" var="admin">
        <tr>
          <td>${admin.name}</td>
          <td>${admin.password}</td>
          <td><a class="btn btn-outline-danger" href="/adminup"> Update </a>
				</td>
          <td><a class="btn btn-outline-danger" href="/admindel"
					onclick="if(!confirm('Are you sure to delete the admin?')) return false"> Delete </a>
				</td>
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