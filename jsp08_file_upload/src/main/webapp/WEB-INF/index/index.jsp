<%@page import="com.user.model.ClockDto"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<h1>INDEX</h1>
<ul>
	<c:forEach items="${clockList}" var="clockDto">
		<li><img
			src="${pageContext.request.contextPath}/uploadClock/${clockDto.clockRealImg}"></li>
		<li>${clockDto.title}</li>
		<li>${clockDto.depth}</li>
		<li>${clockDto.price}</li>
	</c:forEach>
</ul>
<%@ include file="../include/footer.jsp" %>
