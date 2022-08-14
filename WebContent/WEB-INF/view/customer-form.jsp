<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Save Customer</title>
		
	<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css">
		
	<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
	
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>Customer List Manager</h2>
		</div>
	</div>
	
	<div id="contatiner">
		<h3>Save Customer</h3>
		
		<form:form action="saveCustomer" modelAttribute="customer" method="POST">
			<table>
				<tbody>
				
					<tr>
						<td><labeL>First Name</labeL></td>
						<td><form:input path="firstName" /></td>
					</tr>
					
					<tr>
						<td><labeL>Last Name</labeL></td>
						<td><form:input path="lastName" /></td>
					</tr>
					
					<tr>
						<td><labeL>Email</labeL></td>
						<td><form:input path="email" /></td>
					</tr>
					
					<tr>
						<td><labeL></labeL></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>
					
				</tbody>
			</table>
		</form:form>
		
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/customer/list">Back to list</a>
		</p>
		
	</div>

</body>


</html>