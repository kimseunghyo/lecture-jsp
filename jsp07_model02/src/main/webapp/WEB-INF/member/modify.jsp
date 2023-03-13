<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../include/header.jsp"%>
<form action="./modifyProcess" method="POST">
	<table>
		<colgroup>
			<col style="width: 20%" />
			<col style="width: 80%" />
		</colgroup>
		<tbody>
			<tr>
				<th>아이디</th>
				<td><span>${loggedId}</span></td>
			</tr>
			<tr>
				<th>패스워드</th>
				<td><input type="password" name="userPw" id="userPw"
					placeholder="패스워드를 입력하세요." /></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="userName" id="userName"
					placeholder="이름을 입력하세요." /></td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><input type="text" name="userEmail" id="userEmail"
					placeholder="메일을 입력하세요." /></td>
			</tr>
			<tr>
				<th>전화번호</th>
				<td><input type="text" name="userHp" id="userHp"
					placeholder="전화번호를 입력하세요." /></td>
			</tr>
			<tr>
				<th>주소</th>
				<td>
					<div>
						<input type="text" name="zipCode" id="zipCode"
							placeholder="우편번호를 입력하세요." readonly />
						<button class="btn zipCode">우편번호</button>
					</div>
					<div>
						<input type="text" name="userAddr01" id="userAddr01"
							placeholder="기본주소" readonly /> <span>기본주소</span>
					</div>
					<div>
						<input type="text" name="userAddr02" id="userAddr02"
							placeholder="상세주소" /> <input type="text" name="userAddr03"
							id="userAddr03" placeholder="참고사항" />
					</div>
				</td>
			</tr>
		</tbody>
	</table>
	<div>
		<button class="btn confirm">회원정보수정</button>
		<button type="reset">취소</button>
	</div>
</form>
<script>
	
	$(".zipCode").on(
			"click",
			function() {
				new daum.Postcode(
						{
							oncomplete : function(data) {
								// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
								// 각 주소의 노출 규칙에 따라 주소를 조합한다.
								// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
								let addr = ""; // 주소 변수
								let extraAddr = ""; // 참고항목 변수
								//사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
								if (data.userSelectedType === "R") {
									// 사용자가 도로명 주소를 선택했을 경우
									addr = data.roadAddress;
								} else {
									// 사용자가 지번 주소를 선택했을 경우(J)
									addr = data.jibunAddress;
								}
								// 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
								if (data.userSelectedType === "R") {
									// 법정동명이 있을 경우 추가한다. (법정리는 제외)
									// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
									if (data.bname !== ""
											&& /[동|로|가]$/g.test(data.bname)) {
										extraAddr += data.bname;
									}
									// 건물명이 있고, 공동주택일 경우 추가한다.
									if (data.buildingName !== ""
											&& data.apartment === "Y") {
										extraAddr += extraAddr !== "" ? ", "
												+ data.buildingName
												: data.buildingName;
									}
									// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
									if (extraAddr !== "") {
										extraAddr = " (" + extraAddr + ")";
									}
									// 조합된 참고항목을 해당 필드에 넣는다.
									$("#userAddr03").val(extraAddr);
								} else {
									$("#userAddr03").val("");
								}
								// 우편번호와 주소 정보를 해당 필드에 넣는다.
								$("#zipCode").val(data.zonecode);
								$("#userAddr01").val(addr);
								// 커서를 상세주소 필드로 이동한다.
								$("userAddr02").focus();
							},
						}).open();
				return false;
			});
</script>
<%@ include file="../include/footer.jsp"%>