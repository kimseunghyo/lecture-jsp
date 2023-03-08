<%@page import="com.user.utils.ScriptWriter"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
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

String sql = "INSERT INTO BOARD VALUES(BOARD_SEQ.NEXTVAL, ?, ?, ?, ?, sysdate)";

try {
	Class.forName(driver);
	conn = DriverManager.getConnection(url, id, pw);
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, userName);
	pstmt.setString(2, subject);
	pstmt.setString(3, userPW);
	pstmt.setString(4, contents);
	int result = pstmt.executeUpdate();

	if (result > 0) {
		ScriptWriter.alertAndNext(response, "글이 입력되었습니다.", "list.jsp");
	} else {
		ScriptWriter.alertAndBack(response, "서버 오류 입니다. 잠시 후 다시 시도해 주시기 바랍니다.");
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