<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String driver = "oracle.jdbc.OracleDriver";
String url = "jdbc:oracle:thin:@localhost:1521:xe";
String id = "TIS001";
String pw = "1234";

Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

String sql = "SELECT * FROM MEMBER";

Class.forName(driver);
conn = DriverManager.getConnection(url, id, pw);
pstmt = conn.prepareStatement(sql);
rs = pstmt.executeQuery();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
	<%
	while (rs.next()) {
		out.println("<li>"
							+ "<dl><dt>ID</dt><dd>" + rs.getString("USERID") + "</dd></dl>"
							+ "<dl><dt>PW</dt><dd>" + rs.getString("USERPW") + "</dd></dl>"
							+ "<dl><dt>NAME</dt><dd>" + rs.getString("USERNAME") + "</dd></dl>"
							+ "<dl><dt>GENDER</dt><dd>" + rs.getString("GENDER") + "</dd></dl>"
							+ "<dl><dt>GRADE</dt><dd>" + rs.getString("GRADE") + "</dd></dl>"
					);
		out.println("</li>");
	}
	%>
	</ul>
</body>
</html>