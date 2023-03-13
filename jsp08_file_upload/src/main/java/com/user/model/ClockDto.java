package com.user.model;

public class ClockDto {
	private int no;
	private String title;
	private String category;
	private int depth;
	private int price;
	private String clockImg;
	private String clockRealImg;
	
	public ClockDto() {
		super();
	}
	
	public ClockDto(int no, String title, String category, int depth, int price, String clockImg, String clockRealImg) {
		super();
		this.no = no;
		this.title = title;
		this.category = category;
		this.depth = depth;
		this.price = price;
		this.clockImg = clockImg;
		this.clockRealImg = clockRealImg;
	}
	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getClockImg() {
		return clockImg;
	}

	public void setClockImg(String clockImg) {
		this.clockImg = clockImg;
	}

	public String getClockRealImg() {
		return clockRealImg;
	}

	public void setClockRealImg(String clockRealImg) {
		this.clockRealImg = clockRealImg;
	}
}
