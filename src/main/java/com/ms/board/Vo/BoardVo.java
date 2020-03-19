package com.ms.board.Vo;

import java.time.LocalDate;

public class BoardVo {
	
	private int bno;
	private String title;
	private String content;
	private int count;
	private String writer;
	private LocalDate createTime;
	private LocalDate editTime;
	
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public LocalDate getCreateTime() {
		return createTime;
	}
	public void setCreateTime(LocalDate createTime) {
		this.createTime = createTime;
	}
	public LocalDate getEditTime() {
		return editTime;
	}
	public void setEditTime(LocalDate editTIme) {
		this.editTime = editTime;
	}
}
