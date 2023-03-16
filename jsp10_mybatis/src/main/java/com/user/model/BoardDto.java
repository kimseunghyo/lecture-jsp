package com.user.model;

public class BoardDto {
	private int no;
	private String userName;
	private String title;
	private String contents;
	private String regDate;
	private int hit;
	
	public BoardDto() {
		super();
	}

	public BoardDto(int no, String userName, String title, String contents, String regDate, int hit) {
		super();
		this.no = no;
		this.userName = userName;
		this.title = title;
		this.contents = contents;
		this.regDate = regDate;
		this.hit = hit;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

}
