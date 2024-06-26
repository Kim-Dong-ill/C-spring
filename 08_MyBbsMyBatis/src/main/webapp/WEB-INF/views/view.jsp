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
<h2>안녕하세요</h2>
<h2>mybbs 내용 보기</h2>
<div>아이디 : ${dto.id}<br>
	작성자 : ${dto.writer}<br>
	제목 : ${dto.title}<br>
	내용 : ${dto.content}<br>
	<a href="/list"><button>뒤로가기</button><a/>
</div>
</body>
</html>