<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String loggedUserName = (String) session.getAttribute("userName");
String loggedUserID = (String) session.getAttribute("userId");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>회원가입</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link
	href="https://fonts.googleapis.com/css2?family=Lato:wght@100;300;400;700;900&family=Noto+Sans+KR:wght@100;300;400;500;700;900&display=swap"
	rel="stylesheet">
<link rel="stylesheet" href="../css/reset.css">
<link rel="stylesheet" href="../css/common.css">
<link rel="stylesheet" href="../css/layout.css">

<!-- include libraries(jQuery, bootstrap) -->
<script src="../js/jquery-3.6.3.min.js"></script>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script
	src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<!-- include summernote css/js -->
<link href="../summernote/summernote.min.css" rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>
</head>
<body>
	<header id="header" class="header">
		<h1 id="logo">
			<a href="index.jsp">USER'S MEDIA LAB</a>
		</h1>
		<nav id="gnb">
			<h2 class="hidden">global navigation</h2>
			<ul class="list">
				<li><a href="">회원가입</a></li>
				<li><a href="">로그인</a></li>
				<li><a href="">게시판</a></li>
			</ul>
		</nav>
	</header>