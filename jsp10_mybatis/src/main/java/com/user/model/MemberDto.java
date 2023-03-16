package com.user.model;

public class MemberDto {
	private int no;
	private String userId;
	private String userPw;
	private String userName;
	private String regDate;
	
	public MemberDto() {
		super();
	}

	public MemberDto(int no, String userId, String userPw, String userName, String regDate) {
		super();
		this.no = no;
		this.userId = userId;
		this.userPw = userPw;
		this.userName = userName;
		this.regDate = regDate;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
}
