<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>글 목록보기</title>
</head>
<body>
	<h2>게시판 글 목록</h2>
	<hr>
	<table border="1" cellspacing="0" cellpadding="0" width="600">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>글쓴이</th>
			<th>등록일</th>		
		</tr>
		<c:forEach items="${list }" var="dto">
		<tr>
			<th>${dto.bnum }</th>
			<th><a href="contentView.do?bnum=${dto.bnum }">${dto.subject }</a></th>
			<th>${dto.writer }</th>
			<th>${dto.wdate }</th>		
		</tr>
		</c:forEach>
	</table>
	<input type="button" value="글쓰기" onclick="script:window.location.href='write_Form.do'">
</body>
</html>