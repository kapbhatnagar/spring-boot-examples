<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html lang="en">
<head>

<link rel="stylesheet" type="text/css"
	href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

<!-- 
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->
<c:url value="/css/main.css" var="jstlCss" />
<link href="${jstlCss}" rel="stylesheet" />
<title>Employee Add</title>
</head>
<body>

	<div class="container">
		<form:form method="post" modelAttribute="employeeVO">
			<%-- <form:hidden path="id" /> --%>
			<fieldset class="form-group">
				<form:label path="name">Employee Name:</form:label>
				<form:input path="name" type="text" class="form-control"
					required="required" />
				<form:errors path="name" cssClass="text-warning" />
			</fieldset>
			
			<fieldset class="form-group">
				<form:label path="addressLine1">Address Line1:</form:label>
				<form:input path="addressLine1" type="text" class="form-control"
					required="required" />
				<form:errors path="addressLine1" cssClass="text-warning" />
			</fieldset>
			
			<fieldset class="form-group">
				<form:label path="addressLine2">Address Line2:</form:label>
				<form:input path="addressLine2" type="text" class="form-control"
					required="required" />
				<form:errors path="addressLine2" cssClass="text-warning" />
			</fieldset>
			
			<fieldset class="form-group">
				<form:label path="zipCode">ZipCode:</form:label>
				<form:input path="zipCode" type="text" class="form-control"
					required="required" />
				<form:errors path="zipCode" cssClass="text-warning" />
			</fieldset>

			<fieldset class="form-group">
				<form:label path="salary">Salary:</form:label>
				<form:input path="salary" type="text" class="form-control"
					required="required" />
				<form:errors path="salary" cssClass="text-warning" />
			</fieldset>

			<button type="submit" class="btn btn-success">Add</button>
		</form:form>
	</div>



	<script type="text/javascript"
		src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>
