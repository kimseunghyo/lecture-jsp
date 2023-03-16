<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<main>
	<form class="form" action="../board/modifyProcess" method="POST">
		<table class="board">
			<colgroup>
				<col style="width: 20%">
				<col style="width: 80%">
			</colgroup>
			<tbody>
				<tr>
					<th>이름</th>
					<td><input type="text" name="userName" value="${boardDto.userName}"></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" name="title" value="${boardDto.title}"></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea name="contents" id="summernote">${boardDto.contents}</textarea></td>
				</tr>
			</tbody>
		</table>
		<input type="hidden" name="no" value="${boardDto.no}">
		<div class="btns">
			<button class="btn confirm">확인</button>
			<button class="btn reset" type="reset">취소</button>
		</div>
	</form>
</main>
<script>
	$("#summernote").summernote({
		height : 300,
		// 섬머노트에서 제공하는 이벤트 처리 하는 곳
		callbacks : {
			onImageUpload : function(files) {
				console.log("이미지 첨부 됨");
				console.log(files);
				for (let i = 0; i < files.length; i++) {
					uploadImage(files[i], this);
				}
			}
		}
	})

	function uploadImage(file, editor) {
		const sendData = new FormData(); // key:value  <form><input type="file" name="uploadFile"></form>
		sendData.append("uploadFile", file);
		console.log(sendData);
		$.ajax({
			url : "../board/summernoteFileUpload",
			type : "POST",
			data : sendData,
			contentType : false, // true=> enctype="x-www-form-urlencoded" 를 쓰지 않겠다.  false =>  multipart/form-data
			processData : false, // QueryString으로 날아가는걸 막겠다.
			success : function(response) {
				//위에 있는 url에서 응답을 기대하고 있음...
				console.log(response);
				$(editor).summernote("editor.insertImage", response.fileUrl);
			},
			error : function() {
				console.log("파일 업로드 실패");
			}
		})
	}
</script>
<%@ include file="../include/footer.jsp"%>