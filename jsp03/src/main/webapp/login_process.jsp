<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
String userID = request.getParameter("userID");
String userPW = request.getParameter("userPW");

String driver = "oracle.jdbc.OracleDriver";
String url = "jdbc:oracle:thin:@localhost:1521:xe";
String id = "TIS001";
String pw = "1234";

Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

String sql = "SELECT * FROM MEMBER WHERE USERID = ? AND USERPW = ?";

Class.forName(driver);
conn = DriverManager.getConnection(url, id, pw);
pstmt = conn.prepareStatement(sql);
pstmt.setString(1, userID);
pstmt.setString(2, userPW);
rs = pstmt.executeQuery();

if (rs.next()) {
	String _userID = rs.getString("USERID");
	String _userPW = rs.getString("USERPW");
	String _userName = rs.getString("USERNAME");
	String _gender = rs.getString("GENDER");
	String _grade = rs.getString("GRADE");
	
	session.setAttribute("userName", _userName);
	session.setAttribute("gender", _gender);
	session.setAttribute("grade", _grade);
	response.sendRedirect("login_ok.jsp");
} else {
	out.println("<script>alert('아이디 패스워드 확인 해주세요.'); history.back();</script>");
}
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>