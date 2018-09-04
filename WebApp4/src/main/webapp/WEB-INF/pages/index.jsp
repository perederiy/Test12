<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page isELIgnored ="false" %><!-- Директива для того чтобы работали переменные -->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>Hello world</h1><br/>
	<h2>All of users</h2><br/>
	<c:forEach var="user" items="${requestScope.users}">
		<ul>
			<li>Name: <c:out value="${user.name}"/> </li>
			<li>Age: <c:out value="${user.age}"/> </li>
			
			<form method="post" action="delete">
				<input type="hidden" name="id" value="${user.id}"/>
				<input type="submit" name="delete" value="DELETE"/>
			</form>
			
			<form method="get" action="update"/>
				<input type="hidden" name="id" value="${user.id}"/>
				<input type="submit" name="update" value="UPDATE"/>
			</form>
			
		</ul>
	</c:forEach>
	
	<h2>Create new user</h2>
	<form action="add_user" method="post">
	<label><input type="text" name="name"></label>Name<br/>
	<label><input type="text" name="age"></label>Age<br/>
	<input type="submit" value="OK" name="ok">
	</form>
	
</body>
</html>
