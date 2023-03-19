<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<html>


<head>
<title>Custom Login Page</title>


<style type="text/css">
.failed {
	color: red;
	font-family: ui-serif;
}

.form-group {
	display: flex;
	flex-direction: column;
	margin-bottom: 10px;
}

.form-group label {
	margin-bottom: 5px;
}

.form-group input {
	flex: 1;
	padding: 5px;
	max-width: 300px; /* adjust this value as needed */
}

/* media query for screens 600px and below */
@media ( max-width : 600px) {
	.form-group {
		flex-direction: column;
	}
	.form-group input {
		max-width: none;
		width: 100%;
	}
}
</style>
</head>


<body>

	<h3>My custom login page</h3>

	<!-- pageContext.request.contextPath gives the dynamic access to the root  
	/authenticateTheUser spring will automatically implement the security layer on the data.
	After it goes to the controller and user will be taken to the given page. -->
	<form:form
		action="${pageContext.request.contextPath}/authenticateTheUser"
		method="POST">

		<!--  Check for login error -->

		<c:if test="${param.error != null }">

			<i class="failed">Sorry! You entered invalid username/password.</i>

		</c:if>

		<div class="form-group">
			<label for="username">User name:</label> <input type="text"
				id="username" name="username" class="form-input" />
		</div>

		<div class="form-group">
			<label for="password">Password:</label> <input type="password"
				id="password" name="password" class="form-input" />
		</div>

		<input type="submit" value="Login">

	</form:form>

</body>

</html>