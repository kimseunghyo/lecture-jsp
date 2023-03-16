<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<main>
	<form class="form" action="../board/list" method="POST">
		<table class="board">
			<colgroup>
				<col style="width: 20%">
				<col style="width: 80%">
			</colgroup>
			<tbody>
				<tr>
					<th>이름</th>
					<td>${boardDto.userName}</td>
				</tr>
				<tr>
					<th>날짜</th>
					<td>${boardDto.regDate}</td>
				</tr>
				<tr>
					<th>조회수</th>
					<td>${boardDto.hit}</td>
				</tr>
				<tr>
					<th>제목</th>
					<td>${boardDto.title}</td>
				</tr>
				<tr>
					<th>내용</th>
					<td>${boardDto.contents}</td>
				</tr>
			</tbody>
		</table>
	</form>
	<div class="btns">
			<a href="../board/modify?no=${boardDto.no}"  class="btns confirm">수정</a>
			<a href="../board/list"  class="btn reset" >목록</a>
	</div>
</main>
<%@ include file="../include/footer.jsp"%>