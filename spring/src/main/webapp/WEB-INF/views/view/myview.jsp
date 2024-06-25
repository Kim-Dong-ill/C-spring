<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="utf-8"%>
	<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8"/>
<title>Insert title here</title>
</head>
<body>
<h2>안녕하세요 마이뷰입니다.</h2>

<div>
	<c:forEach var="mylist" items="${lists}">
		${mylist}
	</c:forEach>
</div>
</body>
</html>
