<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

</head>
<body>

	<div class="container text-center mt-5">
		<h1>Employees And Mangers</h1>
		<table class="table mt-5">
			<thead>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Employees or Manger</th>
			</thead>
			<tbody>
				<c:forEach var="i" items="${employees}">
					<tr>
						<td><c:out value="${i.firstName }" /></td>
						<td><c:out value="${i.lastName}" /></td>
						<td> Manger <c:out value="${i.manager.firstName}" /> <c:out
								value="${i.manager.lastName}" /></td>
					</tr>
				</c:forEach>
				
			</tbody>
		</table>

	</div>
</body>
</html>