<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="GET" action="join_process.jsp">
		<div>
			<label><span>아이디</span><input type="text" name="userID"></label>
		</div>
		<div>
			<label><span>비밀번호</span><input type="password" name="userPW"></label>
		</div>
		<div>
			<label><span>이름</span><input type="text" name="userName"></label>
		</div>
		<div>
			<label><span>성별</span><input type="radio" name="gender" value="남">남<input type="radio" name="gender" value="여">여</label>
		</div>
		<div>
			<label><span>학력</span>
				<select name = "grade">
					<option value = "초졸">초졸</option>
					<option value = "중졸">중졸</option>
					<option value = "대졸">대졸</option>
					<option value = "대학원졸">대학원졸</option>
				</select>
			</label>
		</div>
		<div>
			<button>회원가입</button>
			<button type="reset">취소</button>
		</div>
	</form>
</body>
</html>