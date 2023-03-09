<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<%
String driver = "oracle.jdbc.OracleDriver";
String url = "jdbc:oracle:thin:@localhost:1521:xe";
String id = "TIS001";
String pw = "1234";

Connection conn = null;
PreparedStatement pstmt = null;
ResultSet rs = null;

String sql = "SELECT * FROM MEMBER02 WHERE USERID = ?";
String userID = (String) session.getAttribute("userId");
String userName = null;
String userEmail = null;
String userHp = null;
int userZipCode = 0;
String userAddress = null;
try {
	Class.forName(driver);
	conn = DriverManager.getConnection(url, id, pw);
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1, userID);
	rs = pstmt.executeQuery();

	while (rs.next()) {
		userName = rs.getString("userName");
		userHp = rs.getString("userHp");
		userZipCode = rs.getInt("zipCode");
		userAddress = rs.getString("address");
		userEmail = rs.getString("userEmail");
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
<table>
	<colgroup>
		<col style="width: 20%" />
		<col style="width: 80%" />
	</colgroup>
	<tbody>
		<tr>
			<th>아이디</th>
			<td><span><%=userID%></span></td>
		</tr>

		<tr>
			<th>이름</th>
			<td><span><%=userName%></span></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><span><%=userEmail%></span></td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td><span><%=userHp%></span></td>
		</tr>
		<tr>
			<th>주소</th>
			<td>
				<div>
					<span><%=userZipCode%></span>
				</div>
				<div>
					<span><%=userAddress%></span>
				</div>
			</td>
		</tr>
	</tbody>
</table>
<div>
	<a href="modify.jsp">회원정보 수정</a> <a href="delete.jsp">회원탈퇴</a>
</div>

<%@ include file="../include/footer.jsp"%>