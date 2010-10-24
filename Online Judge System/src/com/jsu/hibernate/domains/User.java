/**
 * 
 */
package com.jsu.hibernate.domains;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * @author Administrator
 *
 */
public class User implements Serializable {

	private static final long serialVersionUID = -15244181L;
	/**
	 * Fields
	 */
	private String username;
	private String password;
	private String nickname;
	private String email;
	private String motto;
	private String school;
	private Integer submit;
	private Integer accept;
	private Integer solved;
	private Integer unSolved;
	private Date registerTime;
	private Date accessTime;
	private String admin;
	private String defunct;
	private Set<Result> results;
	private Set<Solution> solutions;
	private Set<LoginLog> loginLogs;
	private Set<Contest> contest;
	
	public Integer getUnSolved() {
		return unSolved;
	}

	public void setUnSolved(Integer unSolved) {
		this.unSolved = unSolved;
	}

	public User() {
		submit = 0;
		accept = 0;
		solved = 0;
		unSolved = 0;
		admin = "N";
		defunct = "N";
		
	}
	
	public User(String username, String password, Date registerTime) {
		this.username = username;
		this.password = password;
		this.registerTime = registerTime;
		submit = 0;
		accept = 0;
		solved = 0;
		unSolved = 0;
		admin = "N";
		defunct = "N";
		
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getNickname() {
		return nickname;
	}

	public String getEmail() {
		return email;
	}

	public String getMotto() {
		return motto;
	}

	public String getSchool() {
		return school;
	}

	public Integer getSubmit() {
		return submit;
	}

	public Integer getAccept() {
		return accept;
	}

	public Integer getSolved() {
		return solved;
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	public Date getAccessTime() {
		return accessTime;
	}

	public String getAdmin() {
		return admin;
	}

	public String getDefunct() {
		return defunct;
	}

	public Set<Result> getResults() {
		return results;
	}

	public Set<Solution> getSolutions() {
		return solutions;
	}

	public Set<LoginLog> getLoginLogs() {
		return loginLogs;
	}

	public Set<Contest> getContest() {
		return contest;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setMotto(String motto) {
		this.motto = motto;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public void setSubmit(Integer submit) {
		this.submit = submit;
	}

	public void setAccept(Integer accept) {
		this.accept = accept;
	}

	public void setSolved(Integer solved) {
		this.solved = solved;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public void setAccessTime(Date accessTime) {
		this.accessTime = accessTime;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public void setDefunct(String defunct) {
		this.defunct = defunct;
	}

	public void setResults(Set<Result> results) {
		this.results = results;
	}

	public void setSolutions(Set<Solution> solutions) {
		this.solutions = solutions;
	}

	public void setLoginLogs(Set<LoginLog> loginLogs) {
		this.loginLogs = loginLogs;
	}

	public void setContest(Set<Contest> contest) {
		this.contest = contest;
	}
	

}
