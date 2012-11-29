package org.mocity.bean;

import java.sql.Date;

public class Post {
	int id;	
	int uid;
	int cid;
	String title;
	String content;
	String conpre;
	public String getConpre() {
		return conpre;
	}
	public void setConpre(String conpre) {
		this.conpre = conpre;
	}
	Date date;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

}
