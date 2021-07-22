<%@include file="include/header.jsp" %>
<%@ page import="java.util.List" %>
<%@ page import="org.springframework.ui.Model" %>
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
      </c:forEach>
  </tbody>
			</table>
			
		</div>
	</div>
			</div>
		</div>
		
		<div class="w3-button">
			<a href="${pageContext.request.contextPath}/addmenu">Add New Item</a>
		</div>
		<br/>
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
								 <select class="w3-select" name="id" style="width:100px;">
								 <option value="" disabled selected>Choose id</option>
                                 <c:forEach items="${menu}" var="menu">
                                 <option value="${menu.id}">${menu.id}</option>
                                </c:forEach>
                             </select>
                             <lable>ID</lable>
                            </div>
<input type="submit" formaction="delmenu" value="Delete" onclick="if(!confirm('Are you sure to delete the item?')) return false" style="float:right; margin:10px;">
<input type="submit" formaction="menuup" value="Update" style="float:left; margin:10px;">
</form>
</div>
</div>
</div>
</div>
</div>
</div>
</div>
<%@include file="include/footer.jsp" %>