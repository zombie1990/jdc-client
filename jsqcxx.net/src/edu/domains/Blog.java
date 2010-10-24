package edu.domains;

import java.io.Serializable;
import java.util.Date;

/**
 * @author xiyu
 *
 */
public class Blog implements Serializable {

	private static final long serialVersionUID = -4607456530715537005L;
	
	private String uuid; //primary-key
	private String title; //not null
	private String leftPicURL; //not null
	private String rightPicURL;
	private String content; //not null
	private int clicks; //not null
	private String type; //not null
	private Date postTime; //not null
	
	private User user;
	
	public Blog() {
	}
	
	public Blog(String title, String content, String type, User user) {
		this.title = title;
		this.leftPicURL = "default-icon.png";
		this.content = content;
		this.type = type;
		this.postTime = new Date();
		this.clicks = 0;
		this.user = user;
	}

	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
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

	public int getClicks() {
		return clicks;
	}
	public void setClicks(int clicks) {
		this.clicks = clicks;
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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

	public String getLeftPicURL() {
		return leftPicURL;
	}

	public void setLeftPicURL(String leftPicURL) {
		this.leftPicURL = leftPicURL;
	}

	public String getRightPicURL() {
		return rightPicURL;
	}

	public void setRightPicURL(String rightPicURL) {
		this.rightPicURL = rightPicURL;
	}


}
