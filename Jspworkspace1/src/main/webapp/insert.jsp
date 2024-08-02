<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="bootstrap.jsp" %>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="insert" method="post">
	<input type="text" placeholder="Enter name" class="form-control" name="name">
	<input type="text" placeholder="Enter field" class="form-control" name="field">
	<input type="text" placeholder="Enter phno" class="form-control" name="phno">
	<input type="text" placeholder="Enter salary" class="form-control" name="salary">
	<button type = submit>Add</button>
</form>
</body>
</html>