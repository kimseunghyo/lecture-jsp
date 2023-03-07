<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String userID = (String) session.getAttribute("userId");
String userPW = request.getParameter("userPW");

String driver = "oracle.jdbc.OracleDriver";
String url = "jdbc:oracle:thin:@localhost:1521:xe";
String id = "TIS001";
String pw = "1234";

Connection conn = null;
PreparedStatement pstmt = null;

String sql = "DELETE FROM MEMBER02 WHERE USERID = ? AND USERPW = ?";

try {
	Class.forName(driver);
	conn = DriverManager.getConnection(url, id, pw);
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, userID);
	pstmt.setString(2, userPW);
	int result = pstmt.executeUpdate();

	if (result > 0) {
		out.println("<script>alert('회원탈퇴 되었습니다.');location.href='index.jsp';</script>");
		session.invalidate();
	} else {
		out.println("<script>alert('뭔가 잘못된거 같아요...');history.back();</script>");
	}
} catch (Exception e) {
	e.printStackTrace();
} finally {
	if (pstmt != null)
		pstmt.close();
	if (conn != null)
		conn.close();
}
%>