<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String oneday = request.getParameter("oneday");
System.out.println(oneday);

if (oneday != null && oneday.equals("1")) {
	Cookie popupCookie = new Cookie("popupCookie", "popupCookie");
	popupCookie.setPath(request.getContextPath());
	popupCookie.setMaxAge(60 * 60 * 24);
	response.addCookie(popupCookie);
	System.out.println("쿠키 구워졌음");
}
%>