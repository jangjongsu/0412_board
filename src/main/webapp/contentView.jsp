<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 내용 보기</title>
</head>
<body>
	<h2>글 내용 보기</h2>
	<hr>
	<table border="1" cellspacing="0" cellpadding="0" width="600">
		<tr>
			<th>번호</th>
			<th>${contentDTO.bnum }</th>
		</tr>
		<tr>
			<th>글쓴이</th>
			<th>${contentDTO.writer }</th>
		</tr>
		<tr>
			<th>제목</th>
			<th>${contentDTO.subject }</th>
		</tr>
		<tr>
			<th>내용</th>
			<th>${contentDTO.content }</th>
		</tr>
		<tr>
			<th>등록일</th>
			<th>${contentDTO.wdate }</th>
		</tr>
	</table>
	<input type="button" value="글삭제" onclick="script:window.location.href='delete.do?bnum=${contentDTO.bnum }'">
	<input type="button" value="글목록" onclick="script:window.location.href='list.do'">
</body>
</html>