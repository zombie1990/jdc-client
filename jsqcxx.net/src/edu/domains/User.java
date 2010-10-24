package edu.domains;

import java.io.Serializable;
import java.util.Date;

/**
 * @author xiyu
 *
 */
public class User implements Serializable {

	private static final long serialVersionUID = -1355489625519673034L;
	
	private String username; //primary-key
	private String password; //not null
	private String email; 
	private String contact;
	private String permission; //not null
	private String question; //not null
	private String answer; //not null
	private Date registerTime; //not null
	
	
	public User() {
	}
	
	public User(String username, String password, String question, String answer) {
		this.username = username;
		this.password = password;
		this.permission = "00000000";
		this.question = question;
		this.answer = answer;
		this.registerTime = new Date();
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public Date getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}
	
}
