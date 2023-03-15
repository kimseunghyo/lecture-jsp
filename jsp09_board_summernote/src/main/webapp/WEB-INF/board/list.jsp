<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>

<main>
	<ul>
		<c:forEach items="${boardList }" var="boardDto">
		<li>
			<span>${status.index}</span>
			<span>${boardDto.userName}</span>
			<span><a href="../board/view?no=${boardDto.no}">${boardDto.title}</a></span>
			<span>${boardDto.regDate}</span>
		</li>
		</c:forEach>
	</ul>
	<a href="../board/write">글쓰기</a>
</main>
<%@ include file="../include/footer.jsp"%>