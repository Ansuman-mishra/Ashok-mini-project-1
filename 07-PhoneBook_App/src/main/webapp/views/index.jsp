<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
table {
	text-align: center;
	background-color: cyan;
	color: red;
}
</style>

</head>
<body>
	<h4>Save Contact</h4>
	${succMsg} ${errMsg}

	<form:form action="saveContact?contactId=${contact.contactId}"
		method="POST" modelAttribute="contact">
		<div align="center">
			<table class="center">
				<tr>
					<form:hidden path="contactId" />
					<td>Contact Name</td>
					<td><form:input path="contactName" /></td>
				</tr>
				<tr>
					<td>Contact Number</td>
					<td><form:input path="contactNumber" /></td>
				</tr>
				<tr>
					<td>Contact Email</td>
					<td><form:input path="contactEmail" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Submit" /></td>
				</tr>
			</table>
		</div>

		<a href="viewContacts">View All Contacts</a>
	</form:form>
</body>
</html>