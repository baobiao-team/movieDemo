package com.example.demo.bean;

public class Dynamic {
	
	private String dynamicId;
	
	private String username;
	
	private String text;
	
	private int likeNum;
	
	private int commentNum;
	
	private boolean like;

	public Dynamic() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Dynamic(String dynamicId, String username, String text, int likeNum, int commentNum) {
		super();
		this.dynamicId = dynamicId;
		this.username = username;
		this.text = text;
		this.likeNum = likeNum;
		this.commentNum = commentNum;
	}

	public String getDynamicId() {
		return dynamicId;
	}

	public void setDynamicId(String dynamicId) {
		this.dynamicId = dynamicId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public int getLikeNum() {
		return likeNum;
	}

	public void setLikeNum(int likeNum) {
		this.likeNum = likeNum;
	}

	public int getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}
	
	public boolean isLike() {
		return like;
	}

	public void setLike(boolean like) {
		this.like = like;
	}

	@Override
	public String toString() {
		return "Dynamic [dynamicId=" + dynamicId + ", username=" + username + ", text=" + text + ", likeNum=" + likeNum
				+ ", commentNum=" + commentNum + "]";
	}

	
	
}
