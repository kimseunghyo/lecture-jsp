<%@page import="com.user.utils.CookieManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String userID = request.getParameter("userID");
String userPW = request.getParameter("userPW");
String saveId = request.getParameter("saveId");

String driver = "oracle.jdbc.OracleDriver";
String url = "jdbc:oracle:thin:@localhost:1521:xe";
String id = "TIS001";
String pw = "1234";

Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

String sql = "SELECT * FROM MEMBER02 WHERE USERID = ? AND USERPW = ?";

try {
	Class.forName(driver);
	conn = DriverManager.getConnection(url, id, pw);
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, userID);
	pstmt.setString(2, userPW);
	rs = pstmt.executeQuery();

	if (rs.next()) {
		String userName = rs.getString("USERNAME");
		String userId = rs.getString("USERID");
		session.setAttribute("userName", userName);
		session.setAttribute("userId", userId);

		if (saveId != null && saveId.equals("yes")) {
			CookieManager.makeCookie(response, "saveIdCookie", userID, 60 * 60 * 24 * 30);
		} else {
			CookieManager.deleteCookie(response, "saveIdCookie");
		}
		response.sendRedirect("index.jsp");

	} else {
		out.println("<script>alert('아이디 비밀번호를 확인해 주세요.'); history.back();</script>");
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