<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String userName = (String) session.getAttribute("userName");
    String gender = (String) session.getAttribute("gender");
    String grade = (String) session.getAttribute("grade");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><%= userName  %>님 안녕하세요.</h1>
	<h3><%= gender %> <%=grade %></h3>
</body>
</html>