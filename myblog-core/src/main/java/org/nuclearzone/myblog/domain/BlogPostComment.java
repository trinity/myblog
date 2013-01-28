package org.nuclearzone.myblog.domain;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class BlogPostComment extends AbstractBlogEntity {

	private String text;
	private Date date;
	private String username;
	
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
}