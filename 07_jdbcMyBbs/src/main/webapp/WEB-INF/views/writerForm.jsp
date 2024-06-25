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
<h2>mybbs 내용 보기</h2>
<form action="write" method="post">
	<table width="400" cellpadding="0" cellspacing="0" border="1">
		<tr>
			<td>작성자</td>
			<td>
				<input type="text" name="writer"></input>
			</td>
			<td>제목</td>
			<td>
				<input type="text" name="title"></input>
			</td>
			<td>내용</td>
			<td>
				<input type="text" name="content"></input>
			</td>
		</tr>
		<input type="submit" value="입력"></input>
	</table>
</form>

</body>
</html>