<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored ="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>Name: <c:out value="${requestScope.user.name}"/></div>
<div>Age: <c:out value="${requestScope.user.age}"/></div>

<form action="update" method="post">
	<label>New name: <input type="text" name="name"/></label> <br/>
	<input type="hidden" name="id" value="${requestScope.user.id}"/>
	<input type="submit" name="ok" value="OK"/>
</form>
</body>
</html>