<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String idx = request.getParameter("idx");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="deleteProcess.jsp" method="POST">
		<input type="hidden" name="idx" value="<%= idx %>">
		<input type="password" name="userPW">
		<div>
			<button>삭제</button>
			<button type="reset">취소</button>
			<a href="list.jsp">목록</a>
		</div>
	</form>
</body>
</html>