<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>

<head>
	<title>luv2code Company Home Page</title>
</head>

<body>
	<h2>luv2code Company Home Page</h2>
	<hr>
	<p>
	Welcome to the luv2code company home page!!
	</p>
	<hr>
	<!-- Display user name and row -->
	<p>
		User: <security:authentication property="principal.username"/>
		<br><br>
		Role(s): <security:authentication property="principal.authorities"/>
	</p>
	
	<!-- Add a link to point to /leaders ... this is for the managers  -->
	
	<security:authorize access="hasRole('MANAGER')">
	<p>
		<a href="${pageContext.request.contextPath}/leaders">Leadership Meetings</a>
		(Only for manager role)
	</p>
	</security:authorize>
	
	<!-- Add a link to point to /admins ... this is for the admins  -->
	
	<security:authorize access="hasRole('ADMIN')">
	<p>
		<a href="${pageContext.request.contextPath}/admins">Admin Meetings</a>
		(Only for admin role)
	</p>
	</security:authorize>
	
	<hr>
	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout"
	           method="POST">
		<input type="submit" value="Logout"/>
	</form:form>

</body>

</html>