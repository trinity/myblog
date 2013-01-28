package org.nuclearzone.myblog.domain;

import java.util.Date;
import java.util.Set;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class BlogPost extends AbstractBlogEntity {

	private String title;
	private String text;
	private Date date;
	
	@DBRef
	private BlogUser user;
	
	@DBRef
	private Set<BlogPostComment> comments;
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
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
	
	public BlogUser getUser() {
		return user;
	}
	
	public void setUser(BlogUser user) {
		this.user = user;
	}

	public Set<BlogPostComment> getComments() {
		return comments;
	}

	public void setComments(Set<BlogPostComment> comments) {
		this.comments = comments;
	}
}