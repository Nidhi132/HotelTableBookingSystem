<%@include file="include/header1.jsp" %>
<%@ page import="java.util.List" %>
<%@ page import="org.jss.controller.*" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<br/>
<div class="contact" id="mail">
		<div class="container">
			<div class="wthree-heading">
			<h3>Menu</h3>
			
			<div class="container mtb">
	<div class="row">
		<div style="padding:20px">
			<hr />
			
			<table class="table table-striped table-dark">
				<thead>
				    <td><strong>Id</strong></td>
					<td><strong>Name</strong></td>
					<td><strong>Cost(Rs.)</strong></td>
				</thead>
				<tbody>
      <c:forEach items="${menu}" var="menu">
        <tr>
          <td>${menu.id}</td>
          <td>${menu.name}</td>
          <td>${menu.cost}</td>
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