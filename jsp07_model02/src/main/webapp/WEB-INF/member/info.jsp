<%@page import="com.user.model.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<table>
	<colgroup>
		<col style="width: 20%" />
		<col style="width: 80%" />
	</colgroup>
	<tbody>
		<tr>
			<th>아이디</th>
			<td><span>${memberInfo.userId}</span></td>
		</tr>

		<tr>
			<th>이름</th>
			<td><span>${memberInfo.userName}</span></td>
		</tr>
		<tr>
			<th>이메일</th>
			<td><span>${memberInfo.userEmail}</span></td>
		</tr>
		<tr>
			<th>전화번호</th>
			<td><span>${memberInfo.userHp}</span></td>
		</tr>
		<tr>
			<th>주소</th>
			<td>
				<div>
					<span>${memberInfo.zipCode}</span>
				</div>
				<div>
					<span>${memberInfo.address}</span>
				</div>
			</td>
		</tr>
	</tbody>
</table>
<div>
	<a href="../member/modify">회원정보 수정</a> <a href="../member/delete">회원탈퇴</a>
</div>

<%@ include file="../include/footer.jsp"%>