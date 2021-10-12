package com.bitcamp.myapp.vo;

public class BoardVO {
	private int no;
	private String userid;
	private String subject;
	private String content;
	private int hit;
	private String writedate;
	private String ip;
	
	//여러개의 레코드번호담을 변수
	private int[] noDelArray;
	
	
	public int[] getNoDelArray() {
		return noDelArray;
	}
	public void setNoDelArray(int[] noDelArray) {
		this.noDelArray = noDelArray;
	}
	
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
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
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getWritedate() {
		return writedate;
	}
	public void setWritedate(String writedate) {
		this.writedate = writedate;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
}
