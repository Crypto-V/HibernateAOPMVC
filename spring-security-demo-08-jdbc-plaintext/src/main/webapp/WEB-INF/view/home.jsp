<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>


<html>
<head>
<tittle>Hello page</tittle>

</head>

<body>
	<h3>Yes 2 code company Home Page</h3>

	<hr>
	<p>Welcome to the yes2code Company Home Page</p>

	<hr>

	<!--  display user name and role -->
	User:
	<security:authentication property="principal.username" />

	<br>
	<br> Role(s):
	<security:authentication property="principal.authorities" />
	<hr>


	<!--  Add a link to point to leaders ... this is for the managers -->
	<security:authorize access="hasRole('MANAGER')">

		<p>
			<a href="${pageContext.request.contextPath}/leaders"> Leadership
				meeting</a> (Only for manager )
		</p>

	<hr>

	</security:authorize>



	<!--  Add a link to point to systems ... this is for the administrator -->
	<security:authorize access="hasRole('ADMIN')">
		
		<p>
			<a href="${pageContext.request.contextPath}/systems">
				Administrator Meeting</a> (Only for Administrator )
		</p>
	</security:authorize>
	<hr>

	<!-- Add logout page -->
	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">

		<input type="submit" value="Logout">
	</form:form>
</body>
</html>