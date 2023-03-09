<%@page import="java.sql.ResultSet"%>
<%@page import="com.user.utils.ScriptWriter"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
int idx = Integer.parseInt(request.getParameter("idx"));
String userName = request.getParameter("userName");
String subject = request.getParameter("subject");
String userPW = request.getParameter("userPW");
String contents = request.getParameter("contents");

String driver = "oracle.jdbc.OracleDriver";
String url = "jdbc:oracle:thin:@localhost:1521:xe";
String id = "TIS001";
String pw = "1234";

Connection conn = null;
PreparedStatement pstmt = null;

String sql = "UPDATE BOARD SET USERNAME = ?, SUBJECT = ?, CONTENTS = ? WHERE NO = ? AND USERPW = ?";

try {
	Class.forName(driver);
	conn = DriverManager.getConnection(url, id, pw);
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, userName);
	pstmt.setString(2, subject);
	pstmt.setString(3, contents);
	pstmt.setInt(4, idx);
	pstmt.setString(5, userPW);
	
	int result = pstmt.executeUpdate();
	
	if (result > 0) {
		ScriptWriter.alertAndNext(response, "글이 수정되었습니다.", "list.jsp");
	} else {
		ScriptWriter.alertAndBack(response, "비밀번호를 다시 확인해주세요.");
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