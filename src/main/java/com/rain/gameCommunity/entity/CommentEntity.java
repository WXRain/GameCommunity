package com.rain.gameCommunity.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.stereotype.Repository;

@Repository("CommentEntity")
public class CommentEntity implements Serializable {

	private String title;

	private String comment;

	private Date commentDate;

	private String author;

	private int gameNum;

	public CommentEntity() {
		super();
	}

	public CommentEntity(String title, String comment, Date commentDate, String author, int gameNum) {
		super();
		this.title = title;
		this.comment = comment;
		this.commentDate = commentDate;
		this.author = author;
		this.gameNum = gameNum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getGameNum() {
		return gameNum;
	}

	public void setGameNum(int gameNum) {
		this.gameNum = gameNum;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "CommentEntity [title=" + title + ", comment=" + comment + ", commentDate=" + commentDate + ", author="
				+ author + ", gameNum=" + gameNum + "]";
	}

}
