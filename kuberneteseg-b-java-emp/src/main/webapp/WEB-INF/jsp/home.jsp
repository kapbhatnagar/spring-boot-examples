<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />
<link href="css/main.css" rel="stylesheet" type="text/css">

<link href="${jstlCss}" rel="stylesheet" />
<title>Employee Database</title>
</head>
<body>
	<div class="container">

		<div class="starter-template">
			<h1>Employee Section</h1>
			<table border="1">
				<thead>
					<tr class="table-header">
						<th>Employee Name</th>
						<th>Salary</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="employee" items="${employeeList}">
						<tr>
							<td><c:out value="${employee.name}" /></td>
							<td><c:out value="${employee.salary}" /></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		<p></p>
		<div>
			<a href="/add">Add More Emp</a>
		</div>

	</div>
	<!-- /.container -->

	<script type="text/javascript"
		src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>
