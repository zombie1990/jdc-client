/**
 * 
 */
package com.jsu.struts2.action;

import java.util.Date;

import com.opensymphony.xwork2.ActionSupport;

/**
 * @author Administrator
 *
 */
public class EditContest extends ActionSupport {

	private static final long serialVersionUID = -57112312304L;
	private Integer contestId;
	private String title;
	private String description;
	private String password;
	private Date startTime;
	private Date endTime;
	private Date startDate;
	private Date endDate;
	public Date getStartDate() {
		return startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public Integer getContestId() {
		return contestId;
	}
	public String getTitle() {
		return title;
	}
	public String getDescription() {
		return description;
	}
	public String getPassword() {
		return password;
	}
	public Date getStartTime() {
		return startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setContestId(Integer contestId) {
		this.contestId = contestId;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	public String execute() {
		
		try {
			startDate = startTime;
			endDate = endTime;
			return SUCCESS;
		} catch(Exception e) {
			return "error";
		}

	}
}
