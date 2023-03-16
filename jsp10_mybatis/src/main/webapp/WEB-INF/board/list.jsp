<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<main>
	<ul class="boardList">
		<c:forEach items="${boardList }" var="boardDto" varStatus="status" begin="0">
		<li>
			<span class="no item">${status.index}</span>
			<span class="userName item">${boardDto.userName}</span>
			<span class="title item"><a href="../board/view?no=${boardDto.no}">${boardDto.title}</a></span>
			<span class="date item">${boardDto.regDate}</span>
		</li>
		</c:forEach>
	</ul>
	<div class="btns">
		<a href="../board/write" class="confirm">글쓰기</a>
		<a href="../index" class="reset">홈</a>
	</div>
</main>
<%@ include file="../include/footer.jsp"%>