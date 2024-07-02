<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
	<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<h2>ticket</h2>
<div>
	<form action="./buyticketcard">
		고객 : <input type="text" name="consumerId"><br>
		구매수 : <input type="text" name="amount"><br>
		에러 넣기 : <input type="text" name="error"><br>
	<input type="submit" value="구매">
	</form>
</div>
</body>
</html>