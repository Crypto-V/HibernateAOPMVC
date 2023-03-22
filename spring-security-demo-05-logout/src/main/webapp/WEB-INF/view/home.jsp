<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<tittle>Hello page</tittle>

</head>

<body>
	<h3>Yes 2 code company Home Page</h3>

	<hr>
<p>
	Welcome to the yes2code Company Home Page
	</p>
	
	<!-- Add logout page -->
	
	<form:form action = "${pageContext.request.contextPath}/logout" 
			   method="POST">
			   
			   <input type="submit" value="Logout">
	</form:form>
</body>
</html>