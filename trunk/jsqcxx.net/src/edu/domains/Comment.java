package edu.domains;

import java.io.Serializable;
import java.util.Date;

/**
 * @author xiyu
 *
 */
public class Comment implements Serializable {

	private static final long serialVersionUID = -784841621450182881L;
	
	private String uuid; //primary-key
	private String content; //not null
	private Date postTime; //not null
	
	private User user;
	private Blog blog;
	
	public Comment() {
	}
	
	public Comment(String content, User user, Blog blog) {
		this.content = content;
		this.user = user;
		this.blog = blog;
		this.postTime = new Date();
	}

	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	public Date getPostTime() {
		return postTime;
	}
	public void setPostTime(Date postTime) {
		this.postTime = postTime;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

	public Blog getBlog() {
		return blog;
	}
	public void setBlog(Blog blog) {
		this.blog = blog;
	}
}
