package com.rain.gameCommunity.entity;

import java.io.Serializable;

import org.springframework.stereotype.Repository;
/**
 * 
 * @author wangxinyu
 *
 */
@Repository
public class CommentEntity implements Serializable {

	// 评论标题
	private String title;

	// 评论内容
	private String comment;

	// 评论时间
	private String commentTime;

	// 评论用户
	private String author;

	// 评论游戏ID
	private int gameNum;

	public CommentEntity() {
		super();
	}

	public CommentEntity(String title, String comment, String commentTime, String author, int gameNum) {
		super();
		this.title = title;
		this.comment = comment;
		this.commentTime = commentTime;
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

	public String getCommentTime() {
		return commentTime;
	}

	public void setCommentDate(String commentTime) {
		this.commentTime = commentTime;
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
		return "CommentEntity [title=" + title + ", comment=" + comment + ", commentTime=" + commentTime + ", author="
				+ author + ", gameNum=" + gameNum + "]";
	}

}
