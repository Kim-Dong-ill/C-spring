<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="utf-8"%>
	<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>안녕하세요</h2>
<h2>
	<c:forEach var="dto" items="${lists}">
		<div>${dto.id}</div>
		<a href="/view?id=${dto.id}"><div>${dto.title}</div></a>
		<div>${dto.content}</div>
		<a href="/delete?id=${dto.id}"><button>삭제</button></a>
	</c:forEach>
	<a href="writerForm">글쓰기</a>
</h2>
</body>
</html>