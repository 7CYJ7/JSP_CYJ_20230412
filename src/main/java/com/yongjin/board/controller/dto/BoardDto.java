package com.yongjin.board.controller.dto;

public class BoardDto {
	
	private int bnum;
	private String writer;
	private String subject;
	private String content;
	private String wdate;
	
	public BoardDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BoardDto(int bnum, String writer, String subject, String content, String wdate) {
		super();
		this.bnum = bnum;  // 게시판 글번호(기본키)
		this.writer = writer; // 글쓴이 이름
		this.subject = subject; // 글 제목
		this.content = content; // 글 내용
		this.wdate = wdate; // 글쓴 일시
	}

	public int getBnum() {
		return bnum;
	}

	public void setBnum(int bnum) {
		this.bnum = bnum;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWdate() {
		return wdate;
	}

	public void setWdate(String wdate) {
		this.wdate = wdate;
	}
	
	

}
